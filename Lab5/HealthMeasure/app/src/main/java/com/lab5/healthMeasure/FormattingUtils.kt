
package com.lab5.healthMeasure

import android.text.style.RelativeSizeSpan
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans
import java.time.Duration
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

private const val UNITS_RELATIVE_SIZE = .6f
private val MINUTES_PER_HOUR = TimeUnit.HOURS.toMinutes(1)
private val SECONDS_PER_MINUTE = TimeUnit.MINUTES.toSeconds(1)


fun formatElapsedTime(elapsedDuration: Duration, includeSeconds: Boolean) = buildSpannedString {
    val hours = elapsedDuration.toHours()
    if (hours > 0) {
        append(hours.toString())
        inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
            append("h")
        }
    }
    val minutes = elapsedDuration.toMinutes() % MINUTES_PER_HOUR
    append("%02d".format(minutes))
    inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
        append("m")
    }
    if (includeSeconds) {
        val seconds = elapsedDuration.seconds % SECONDS_PER_MINUTE
        append("%02d".format(seconds))
        inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
            append("s")
        }
    }
}

fun formatDistanceKm(meters: Double) = buildSpannedString {
    append("%02.2f".format(meters / 1_000))
    inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
        append("km")
    }
}

fun formatCalories(calories: Double) = buildSpannedString {
    append(calories.roundToInt().toString())
    inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
        append(" cal")
    }
}
