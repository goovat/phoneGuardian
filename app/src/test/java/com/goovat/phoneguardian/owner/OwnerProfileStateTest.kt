package com.goovat.phoneguardian.owner

import org.junit.Assert.assertEquals
import org.junit.Test

class OwnerProfileStateTest {

    @Test
    fun contains_expected_states() {
        assertEquals(
            listOf(
                OwnerProfileState.NOT_ENROLLED,
                OwnerProfileState.ENROLLED,
                OwnerProfileState.DISABLED
            ),
            OwnerProfileState.entries
        )
    }
}
