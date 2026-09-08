package com.goovat.phoneguardian.location

class LocationHistory {

    private val locations = mutableListOf<CurrentLocation>()

    fun add(location: CurrentLocation) {
        locations.add(location)
    }

    fun locations(): List<CurrentLocation> = locations.toList()

    fun lastKnown(): LastKnownLocation? {
        return locations.lastOrNull()?.let { LastKnownLocation(it) }
    }
}
