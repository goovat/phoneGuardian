package com.goovat.phoneguardian.location

import android.annotation.SuppressLint
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource

class LocationReporter(
    private val locationClient: FusedLocationProviderClient
) {

    @SuppressLint("MissingPermission")
    fun requestCurrentLocation(
        onLocation: (CurrentLocation) -> Unit,
        onUnavailable: () -> Unit
    ) {
        locationClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY,
            CancellationTokenSource().token
        )
            .addOnSuccessListener { location ->
                if (location == null) {
                    onUnavailable()
                    return@addOnSuccessListener
                }

                onLocation(
                    CurrentLocation(
                        latitude = location.latitude,
                        longitude = location.longitude,
                        accuracyMeters = location.accuracy,
                        timestampMillis = location.time
                    )
                )
            }
            .addOnFailureListener {
                onUnavailable()
            }
    }
}
