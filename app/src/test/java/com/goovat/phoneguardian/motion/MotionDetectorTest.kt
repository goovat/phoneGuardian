package com.goovat.phoneguardian.motion

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MotionDetectorTest {

    @Test
    fun detects_motion_when_acceleration_exceeds_threshold() {
        val detector = MotionDetector()

        val detected = detector.detect(
            accelerationX = 5.0f,
            accelerationY = 0.0f,
            accelerationZ = 0.0f,
            threshold = 3.0f
        )

        assertTrue(detected)
    }

    @Test
    fun does_not_detect_motion_below_threshold() {
        val detector = MotionDetector()

        val detected = detector.detect(
            accelerationX = 1.0f,
            accelerationY = 1.0f,
            accelerationZ = 1.0f,
            threshold = 3.0f
        )

        assertFalse(detected)
    }

    @Test
    fun detects_motion_from_combined_axes() {
        val detector = MotionDetector()

        val detected = detector.detect(
            accelerationX = 2.0f,
            accelerationY = 2.0f,
            accelerationZ = 2.0f,
            threshold = 3.0f
        )

        assertTrue(detected)
    }
}
