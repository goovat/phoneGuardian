package com.goovat.phoneguardian.location

import org.junit.Assert.assertEquals
import org.junit.Test

class LastKnownLocationTest {

    @Test
    fun preservesCurrentLocation() {
        val currentLocation = CurrentLocation(
            latitude = 4.8156,
            longitude = 7.0498,
            accuracyMeters = 8.5f,
            timestampMillis = 1_700_000_000_000L
        )

        val lastKnownLocation = LastKnownLocation(
            location = currentLocation
        )

        assertEquals(currentLocation, lastKnownLocation.location)
    }
}
