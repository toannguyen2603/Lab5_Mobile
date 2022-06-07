
package com.lab5.healthMeasure

import android.util.Log
import androidx.concurrent.futures.await
import androidx.health.services.client.ExerciseUpdateListener
import androidx.health.services.client.HealthServicesClient
import androidx.health.services.client.data.Availability
import androidx.health.services.client.data.ComparisonType
import androidx.health.services.client.data.DataType
import androidx.health.services.client.data.DataTypeCondition
import androidx.health.services.client.data.ExerciseConfig
import androidx.health.services.client.data.ExerciseGoal
import androidx.health.services.client.data.ExerciseLapSummary
import androidx.health.services.client.data.ExerciseTrackedStatus
import androidx.health.services.client.data.ExerciseType
import androidx.health.services.client.data.ExerciseTypeCapabilities
import androidx.health.services.client.data.ExerciseUpdate
import androidx.health.services.client.data.LocationAvailability
import androidx.health.services.client.data.Value
import androidx.health.services.client.data.WarmUpConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class HealthServicesManager @Inject constructor(
    healthServicesClient: HealthServicesClient,
    coroutineScope: CoroutineScope
) {
    private val exerciseClient = healthServicesClient.exerciseClient

    private var exerciseCapabilities: ExerciseTypeCapabilities? = null
    private var capabilitiesLoaded = false

    suspend fun getExerciseCapabilities(): ExerciseTypeCapabilities? {
        if (!capabilitiesLoaded) {
            val capabilities = exerciseClient.capabilities.await()
            if (ExerciseType.RUNNING in capabilities.supportedExerciseTypes) {
                exerciseCapabilities =
                    capabilities.getExerciseTypeCapabilities(ExerciseType.RUNNING)
            }
            capabilitiesLoaded = true
        }
        return exerciseCapabilities
    }

    suspend fun hasExerciseCapability(): Boolean {
        return getExerciseCapabilities() != null
    }

    suspend fun isExerciseInProgress(): Boolean {
        val exerciseInfo = exerciseClient.currentExerciseInfo.await()
        return exerciseInfo.exerciseTrackedStatus == ExerciseTrackedStatus.OWNED_EXERCISE_IN_PROGRESS
    }

    suspend fun isTrackingExerciseInAnotherApp(): Boolean {
        val exerciseInfo = exerciseClient.currentExerciseInfo.await()
        return exerciseInfo.exerciseTrackedStatus == ExerciseTrackedStatus.OTHER_APP_IN_PROGRESS
    }

    suspend fun startExercise() {
        Log.d(TAG, "Starting healthmeasure")
        // Types for which we want to receive metrics. Only ask for ones that are supported.
        val capabilities = getExerciseCapabilities() ?: return
        val dataTypes = setOf(
            DataType.HEART_RATE_BPM,
        ).intersect(capabilities.supportedDataTypes)

        val aggDataTypes = setOf(
            DataType.TOTAL_CALORIES,
            DataType.DISTANCE
        ).intersect(capabilities.supportedDataTypes)

        val exerciseGoals = mutableListOf<ExerciseGoal>()
        if (supportsCalorieGoal(capabilities)) {
            // Create a one-time goal.
            exerciseGoals.add(
                ExerciseGoal.createOneTimeGoal(
                    DataTypeCondition(
                        dataType = DataType.TOTAL_CALORIES,
                        threshold = Value.ofDouble(CALORIES_THRESHOLD),
                        comparisonType = ComparisonType.GREATER_THAN_OR_EQUAL
                    )
                )
            )
        }

        if (supportsDistanceMilestone(capabilities)) {
            // Create a milestone goal. To make a milestone for every kilometer, set the initial
            // threshold to 1km and the period to 1km.
            exerciseGoals.add(
                ExerciseGoal.createMilestone(
                    condition = DataTypeCondition(
                        dataType = DataType.DISTANCE,
                        threshold = Value.ofDouble(DISTANCE_THRESHOLD),
                        comparisonType = ComparisonType.GREATER_THAN_OR_EQUAL
                    ),
                    period = Value.ofDouble(DISTANCE_THRESHOLD)
                )
            )
        }

        val config = ExerciseConfig.builder()
            .setExerciseType(ExerciseType.RUNNING)
            .setShouldEnableAutoPauseAndResume(false)
            .setAggregateDataTypes(aggDataTypes)
            .setDataTypes(dataTypes)
            .setExerciseGoals(exerciseGoals)
            // Required for GPS for LOCATION data type, optional for some other types.
            .setShouldEnableGps(true)
            .build()
        exerciseClient.startExercise(config).await()
    }

    private fun supportsCalorieGoal(capabilities: ExerciseTypeCapabilities): Boolean {
        val supported = capabilities.supportedGoals[DataType.TOTAL_CALORIES]
        return supported != null && ComparisonType.GREATER_THAN_OR_EQUAL in supported
    }

    private fun supportsDistanceMilestone(capabilities: ExerciseTypeCapabilities): Boolean {
        val supported = capabilities.supportedMilestones[DataType.DISTANCE]
        return supported != null && ComparisonType.GREATER_THAN_OR_EQUAL in supported
    }

    suspend fun prepareExercise() {
        Log.d(TAG, "Preparing an healthmeasure")

        val warmUpConfig = WarmUpConfig.builder()
            .setExerciseType(ExerciseType.RUNNING)
            .setDataTypes(
                setOf(
                    DataType.HEART_RATE_BPM,
                    DataType.LOCATION
                )
            )
            .build()

        try {
            exerciseClient.prepareExercise(warmUpConfig).await()
        } catch (e: Exception) {
            Log.e(TAG, "Prepare healthmeasure failed - ${e.message}")
        }
    }

    suspend fun endExercise() {
        Log.d(TAG, "Ending healthmeasure")
        exerciseClient.endExercise().await()
    }

    suspend fun pauseExercise() {
        Log.d(TAG, "Pausing healthmeasure")
        exerciseClient.pauseExercise().await()
    }

    suspend fun resumeExercise() {
        Log.d(TAG, "Resuming healthmeasure")
        exerciseClient.resumeExercise().await()
    }

    suspend fun markLap() {
        if (isExerciseInProgress()) {
            exerciseClient.markLap().await()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val exerciseUpdateFlow = callbackFlow<ExerciseMessage> {
        val listener = object : ExerciseUpdateListener {
            override fun onExerciseUpdate(update: ExerciseUpdate) {
                coroutineScope.runCatching {
                    trySendBlocking(ExerciseMessage.ExerciseUpdateMessage(update))
                }
            }

            override fun onLapSummary(lapSummary: ExerciseLapSummary) {
                coroutineScope.runCatching {
                    trySendBlocking(ExerciseMessage.LapSummaryMessage(lapSummary))
                }
            }

            override fun onAvailabilityChanged(dataType: DataType, availability: Availability) {
                if (availability is LocationAvailability) {
                    coroutineScope.runCatching {
                        trySendBlocking(ExerciseMessage.LocationAvailabilityMessage(availability))
                    }
                }
            }
        }
        exerciseClient.setUpdateListener(listener)
        awaitClose {
            exerciseClient.clearUpdateListener(listener)
        }
    }

    private companion object {
        const val CALORIES_THRESHOLD = 250.0
        const val DISTANCE_THRESHOLD = 1_000.0 // meters
    }
}

sealed class ExerciseMessage {
    class ExerciseUpdateMessage(val exerciseUpdate: ExerciseUpdate) : ExerciseMessage()
    class LapSummaryMessage(val lapSummary: ExerciseLapSummary) : ExerciseMessage()
    class LocationAvailabilityMessage(val locationAvailability: LocationAvailability) :
        ExerciseMessage()
}
