package com.goovat.phoneguardian.sim

class SimProtection(
    private val changeDetection: SimChangeDetection
) {

    fun check(
        protection: SimProtectionEnabled,
        previous: SimStateDetection,
        current: SimStateDetection
    ): SimChangeAlert? {
        if (!protection.enabled) {
            return null
        }

        if (!changeDetection.detect(previous, current)) {
            return null
        }

        return SimChangeAlert(
            event = SimChangeEvent(
                previousSubscriptionId = previous.subscriptionId,
                currentSubscriptionId = current.subscriptionId
            )
        )
    }
}
