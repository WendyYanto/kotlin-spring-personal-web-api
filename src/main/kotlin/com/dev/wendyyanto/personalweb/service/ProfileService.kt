package com.dev.wendyyanto.personalweb.service

import com.dev.wendyyanto.personalweb.model.entity.Profile
import com.dev.wendyyanto.personalweb.model.request.UpdateProfileRequest

interface ProfileService {

  fun getProfile(): Profile

  fun updateProfile(updateProfileRequest: UpdateProfileRequest): Profile
}