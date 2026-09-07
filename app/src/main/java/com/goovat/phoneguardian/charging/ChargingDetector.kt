package com.goovat.phoneguardian.charging

class ChargingDetector {

    fun detect(
        wasCharging: Boolean,
        isCharging: Boolean
    ): ChargingState {
        return when {
            !wasCharging && isCharging -> ChargingState.CONNECTED
            wasCharging && !isCharging -> ChargingState.DISCONNECTED
            else -> ChargingState.UNCHANGED
        }
    }
}
