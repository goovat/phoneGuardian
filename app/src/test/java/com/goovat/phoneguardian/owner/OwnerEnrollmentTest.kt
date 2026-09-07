package com.goovat.phoneguardian.owner

import org.junit.Assert.assertEquals
import org.junit.Test

class OwnerEnrollmentTest {

    @Test
    fun enrollment_returns_profile() {
        val profile = OwnerProfile(
            id = "owner-1",
            name = OwnerName("Owner"),
            state = OwnerProfileState.ENROLLED
        )

        val enrollment = object : OwnerEnrollment {
            override fun enroll(profile: OwnerProfile): Result<OwnerProfile> {
                return Result.success(profile)
            }
        }

        assertEquals(profile, enrollment.enroll(profile).getOrThrow())
    }
}
