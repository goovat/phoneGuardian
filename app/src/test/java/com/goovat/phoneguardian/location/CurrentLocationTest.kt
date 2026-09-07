package com.goovat.phoneguardian.location

import org.junit.Assert.assertEquals
import org.junit.Test

class CurrentLocationTest {

    @Test
    fun preservesLocationValues() {
        val location = CurrentLocation(
            latitude = 4.8156,
            longitude = 7.0498,
            accuracyMeters = 8.5f,
            timestampMillis = 1_700_000_000_000L
        )

        assertEquals(4.8156, location.latitude, 0.0)
        assertEquals(7.0498, location.longitude, 0.0)
        assertEquals(8.5f, location.accuracyMeters, 0.0f)
        assertEquals(1_700_000_000_000L, location.timestampMillis)
    }
}
