package com.goovat.phoneguardian.location

import org.junit.Assert.assertEquals
import org.junit.Test

class LocationPermissionTest {

    @Test
    fun representsGrantedPermission() {
        assertEquals(
            LocationPermission.GRANTED,
            LocationPermission.valueOf("GRANTED")
        )
    }

    @Test
    fun representsNotGrantedPermission() {
        assertEquals(
            LocationPermission.NOT_GRANTED,
            LocationPermission.valueOf("NOT_GRANTED")
        )
    }
}
