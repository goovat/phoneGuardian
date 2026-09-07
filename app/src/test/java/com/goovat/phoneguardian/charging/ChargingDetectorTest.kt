package com.goovat.phoneguardian.charging

import org.junit.Assert.assertEquals
import org.junit.Test

class ChargingDetectorTest {

    @Test
    fun detects_charger_connection() {
        val detector = ChargingDetector()

        val state = detector.detect(
            wasCharging = false,
            isCharging = true
        )

        assertEquals(ChargingState.CONNECTED, state)
    }

    @Test
    fun detects_charger_disconnection() {
        val detector = ChargingDetector()

        val state = detector.detect(
            wasCharging = true,
            isCharging = false
        )

        assertEquals(ChargingState.DISCONNECTED, state)
    }

    @Test
    fun reports_unchanged_when_still_charging() {
        val detector = ChargingDetector()

        val state = detector.detect(
            wasCharging = true,
            isCharging = true
        )

        assertEquals(ChargingState.UNCHANGED, state)
    }

    @Test
    fun reports_unchanged_when_still_not_charging() {
        val detector = ChargingDetector()

        val state = detector.detect(
            wasCharging = false,
            isCharging = false
        )

        assertEquals(ChargingState.UNCHANGED, state)
    }
}
