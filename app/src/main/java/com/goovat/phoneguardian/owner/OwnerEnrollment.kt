package com.goovat.phoneguardian.owner

interface OwnerEnrollment {
    fun enroll(profile: OwnerProfile): Result<OwnerProfile>
}
