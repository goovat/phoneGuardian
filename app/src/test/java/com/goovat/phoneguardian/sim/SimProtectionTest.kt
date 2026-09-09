package com.goovat.phoneguardian.sim

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SimProtectionTest {

    private val protection = SimProtection(SimChangeDetection())

    @Test
    fun detects_sim_change_when_subscription_id_changes() {
        val previous = SimStateDetection("subscription-1")
        val current = SimStateDetection("subscription-2")

        val result = protection.check(
            protection = SimProtectionEnabled(true),
            previous = previous,
            current = current
        )

        assertNotNull(result)
        assertEquals("subscription-1", result?.event?.previousSubscriptionId)
        assertEquals("subscription-2", result?.event?.currentSubscriptionId)
    }

    @Test
    fun does_not_detect_change_when_subscription_id_is_unchanged() {
        val state = SimStateDetection("subscription-1")

        val result = protection.check(
            protection = SimProtectionEnabled(true),
            previous = state,
            current = state
        )

        assertNull(result)
    }

    @Test
    fun does_not_detect_change_when_protection_is_disabled() {
        val previous = SimStateDetection("subscription-1")
        val current = SimStateDetection("subscription-2")

        val result = protection.check(
            protection = SimProtectionEnabled(false),
            previous = previous,
            current = current
        )

        assertNull(result)
    }

    @Test
    fun change_detection_returns_true_for_different_subscription_ids() {
        val detector = SimChangeDetection()

        assertTrue(
            detector.detect(
                SimStateDetection("subscription-1"),
                SimStateDetection("subscription-2")
            )
        )
    }

    @Test
    fun alert_contains_the_sim_change_event() {
        val previous = SimStateDetection("subscription-1")
        val current = SimStateDetection("subscription-2")

        val result = protection.check(
            protection = SimProtectionEnabled(true),
            previous = previous,
            current = current
        )

        assertEquals(
            SimChangeEvent(
                previousSubscriptionId = "subscription-1",
                currentSubscriptionId = "subscription-2"
            ),
            result?.event
        )
    }
}
