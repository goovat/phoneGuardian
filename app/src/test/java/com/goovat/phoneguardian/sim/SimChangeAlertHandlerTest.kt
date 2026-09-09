package com.goovat.phoneguardian.sim

import com.goovat.phoneguardian.core.TimeProvider
import com.goovat.phoneguardian.evidence.SecurityEventType
import com.goovat.phoneguardian.history.SecurityHistory
import com.goovat.phoneguardian.security.SecurityEventRecorder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class SimChangeAlertHandlerTest {

    @Test
    fun records_sim_change_alert_as_security_event() {
        val history = SecurityHistory()
        val recorder = SecurityEventRecorder(history)

        val timeProvider = object : TimeProvider {
            override fun currentTimeMillis(): Long = 1_000L
        }

        val handler = SimChangeAlertHandler(
            recorder = recorder,
            timeProvider = timeProvider
        )

        val alert = SimChangeAlert(
            event = SimChangeEvent(
                previousSubscriptionId = "subscription-1",
                currentSubscriptionId = "subscription-2"
            )
        )

        handler.handle(
            alert = alert,
            eventId = "event-1"
        )

        val events = history.events()

        assertEquals(1, events.size)

        val event = events.first()

        assertEquals("event-1", event.id)
        assertEquals(SecurityEventType.SIM_CHANGED, event.type)
        assertEquals(1_000L, event.timestampMillis)
        assertEquals(
            "SIM subscription changed from subscription-1 to subscription-2",
            event.details
        )
    }

    @Test
    fun records_alert_without_losing_the_original_sim_change() {
        val history = SecurityHistory()
        val recorder = SecurityEventRecorder(history)

        val handler = SimChangeAlertHandler(
            recorder = recorder,
            timeProvider = object : TimeProvider {
                override fun currentTimeMillis(): Long = 2_000L
            }
        )

        val alert = SimChangeAlert(
            event = SimChangeEvent(
                previousSubscriptionId = "old-subscription",
                currentSubscriptionId = "new-subscription"
            )
        )

        handler.handle(
            alert = alert,
            eventId = "event-2"
        )

        val event = history.events().firstOrNull()

        assertNotNull(event)
        assertEquals(
            "SIM subscription changed from old-subscription to new-subscription",
            event?.details
        )
    }
}
