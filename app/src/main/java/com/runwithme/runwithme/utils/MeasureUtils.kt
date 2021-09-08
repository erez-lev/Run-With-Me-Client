package com.runwithme.runwithme.utils

object MeasureUtils {
    fun convertPaceToMinutes(pace: String): Float {
        val content = pace.split(":")
        val minutes = content[0].toFloat()
        val seconds = content[1].toFloat() / 60


        return minutes + seconds
    }
}