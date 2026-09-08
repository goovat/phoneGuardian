package com.goovat.phoneguardian.battery

data class BatteryState(
    val level: BatteryLevel,
    val isCharging: Boolean
)
