package com.goovat.phoneguardian.location

import org.junit.Assert.assertEquals
import org.junit.Test

class LocationHistoryTest {

    @Test
    fun preservesLocationsInInsertionOrder() {
        val first = CurrentLocation(
            latitude = 4.8156,
            longitude = 7.0498,
            accuracyMeters = 8.5f,
            timestampMillis = 1_700_000_000_000L
        )

        val second = CurrentLocation(
            latitude = 4.8200,
            longitude = 7.0550,
            accuracyMeters = 10.0f,
            timestampMillis = 1_700_000_001_000L
        )

        val history = LocationHistory()

        history.add(first)
        history.add(second)

        assertEquals(listOf(first, second), history.locations())
    }

    @Test
    fun returnsSnapshotOfLocations() {
        val location = CurrentLocation(
            latitude = 4.8156,
            longitude = 7.0498,
            accuracyMeters = 8.5f,
            timestampMillis = 1_700_000_000_000L
        )

        val history = LocationHistory()
        history.add(location)

        val snapshot = history.locations()

        history.add(
            CurrentLocation(
                latitude = 4.8200,
                longitude = 7.0550,
                accuracyMeters = 10.0f,
                timestampMillis = 1_700_000_001_000L
            )
        )

        assertEquals(listOf(location), snapshot)
        assertEquals(2, history.locations().size)
    }
}
