package com.goovat.phoneguardian.location

data class CurrentLocation(
    val latitude: Double,
    val longitude: Double,
    val accuracyMeters: Float,
    val timestampMillis: Long
)
