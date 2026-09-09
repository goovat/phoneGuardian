package com.goovat.phoneguardian.sim

data class SimChangeEvent(
    val previousSubscriptionId: String,
    val currentSubscriptionId: String
)
