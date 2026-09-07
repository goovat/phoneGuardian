package com.goovat.phoneguardian.owner

import org.junit.Assert.assertEquals
import org.junit.Test

class OwnerProfileTest {

    @Test
    fun stores_profile_information() {
        val profile = OwnerProfile(
            id = "owner-1",
            name = OwnerName("Owner"),
            state = OwnerProfileState.ENROLLED
        )

        assertEquals("owner-1", profile.id)
        assertEquals("Owner", profile.name.value)
        assertEquals(OwnerProfileState.ENROLLED, profile.state)
    }
}
