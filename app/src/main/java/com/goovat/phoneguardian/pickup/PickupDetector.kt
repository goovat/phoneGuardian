package com.goovat.phoneguardian.pickup

class PickupDetector {

    fun detect(
        wasStationary: Boolean,
        motionDetected: Boolean
    ): Boolean {
        return wasStationary && motionDetected
    }
}
