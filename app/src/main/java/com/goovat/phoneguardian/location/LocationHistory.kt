package com.goovat.phoneguardian.location

class LocationHistory {

    private val locations = mutableListOf<CurrentLocation>()

    fun add(location: CurrentLocation) {
        locations.add(location)
    }

    fun locations(): List<CurrentLocation> = locations.toList()
}
