package com.goovat.phoneguardian.sim

class SimChangeDetection {

    fun detect(
        previous: SimStateDetection,
        current: SimStateDetection
    ): Boolean {
        return previous.subscriptionId != current.subscriptionId
    }
}
