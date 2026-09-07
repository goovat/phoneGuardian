package com.goovat.phoneguardian.owner

import org.junit.Assert.assertEquals
import org.junit.Test

class OwnerNameTest {

    @Test
    fun stores_owner_name() {
        val name = OwnerName("Owner")

        assertEquals("Owner", name.value)
    }
}
