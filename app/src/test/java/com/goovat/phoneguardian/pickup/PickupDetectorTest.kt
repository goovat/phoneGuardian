package com.goovat.phoneguardian.pickup

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PickupDetectorTest {

    @Test
    fun detects_pickup_when_stationary_device_starts_moving() {
        val detector = PickupDetector()

        val detected = detector.detect(
            wasStationary = true,
            motionDetected = true
        )

        assertTrue(detected)
    }

    @Test
    fun does_not_detect_pickup_when_device_was_not_stationary() {
        val detector = PickupDetector()

        val detected = detector.detect(
            wasStationary = false,
            motionDetected = true
        )

        assertFalse(detected)
    }

    @Test
    fun does_not_detect_pickup_without_motion() {
        val detector = PickupDetector()

        val detected = detector.detect(
            wasStationary = true,
            motionDetected = false
        )

        assertFalse(detected)
    }
}
