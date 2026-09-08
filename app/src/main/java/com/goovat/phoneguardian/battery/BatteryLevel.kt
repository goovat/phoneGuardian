package com.goovat.phoneguardian.battery

data class BatteryLevel(
    val percentage: Int
) {
    init {
        require(percentage in 0..100) {
            "Battery percentage must be between 0 and 100"
        }
    }
}
