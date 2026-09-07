package com.goovat.phoneguardian.motion

class MotionDetector {

    fun detect(
        accelerationX: Float,
        accelerationY: Float,
        accelerationZ: Float,
        threshold: Float
    ): Boolean {
        val magnitudeSquared =
            accelerationX * accelerationX +
            accelerationY * accelerationY +
            accelerationZ * accelerationZ

        return magnitudeSquared >= threshold * threshold
    }
}
