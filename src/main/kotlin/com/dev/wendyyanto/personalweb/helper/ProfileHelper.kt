package com.dev.wendyyanto.personalweb.helper

import com.dev.wendyyanto.personalweb.model.entity.Profile
import com.dev.wendyyanto.personalweb.model.response.ProfileResponse
import org.springframework.stereotype.Service

@Service
class ProfileHelper {

  fun toProfileResponse(profile: Profile): ProfileResponse {
    return ProfileResponse(
        name = profile.name.orEmpty()
    )
  }
}