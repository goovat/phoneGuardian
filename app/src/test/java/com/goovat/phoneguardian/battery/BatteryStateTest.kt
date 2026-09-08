package com.goovat.phoneguardian.battery

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BatteryStateTest {

    @Test
    fun accepts_valid_battery_percentage() {
        val level = BatteryLevel(75)

        assertEquals(75, level.percentage)
    }

    @Test
    fun accepts_zero_percent() {
        val level = BatteryLevel(0)

        assertEquals(0, level.percentage)
    }

    @Test
    fun accepts_full_battery() {
        val level = BatteryLevel(100)

        assertEquals(100, level.percentage)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rejects_percentage_below_zero() {
        BatteryLevel(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rejects_percentage_above_one_hundred() {
        BatteryLevel(101)
    }

    @Test
    fun represents_charging_state() {
        val state = BatteryState(
            level = BatteryLevel(60),
            isCharging = true
        )

        assertEquals(60, state.level.percentage)
        assertTrue(state.isCharging)
    }

    @Test
    fun represents_not_charging_state() {
        val state = BatteryState(
            level = BatteryLevel(40),
            isCharging = false
        )

        assertEquals(40, state.level.percentage)
        assertFalse(state.isCharging)
    }
}
