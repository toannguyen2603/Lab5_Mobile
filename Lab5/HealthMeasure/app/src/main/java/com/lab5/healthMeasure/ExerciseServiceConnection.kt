
package com.lab5.healthMeasure

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope

class ExerciseServiceConnection : ServiceConnection, LifecycleOwner {

    var exerciseService: ExerciseService? = null

    private val lifecycleRegistry = LifecycleRegistry(this).apply {
        currentState = Lifecycle.State.INITIALIZED
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        exerciseService = (service as ExerciseService.LocalBinder).getService()
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    override fun onServiceDisconnected(name: ComponentName) {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
    }

    suspend fun repeatWhenConnected(block: suspend CoroutineScope.(ExerciseService) -> Unit) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            block(exerciseService as ExerciseService)
        }
    }
}
