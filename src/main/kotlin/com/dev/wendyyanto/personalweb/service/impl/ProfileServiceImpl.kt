package com.dev.wendyyanto.personalweb.service.impl

import com.dev.wendyyanto.personalweb.constant.ErrorCode
import com.dev.wendyyanto.personalweb.exception.DataNotFoundException
import com.dev.wendyyanto.personalweb.helper.ProfileHelper
import com.dev.wendyyanto.personalweb.model.entity.Profile
import com.dev.wendyyanto.personalweb.model.request.UpdateProfileRequest
import com.dev.wendyyanto.personalweb.repository.ProfileRepository
import com.dev.wendyyanto.personalweb.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileServiceImpl constructor(
    @Autowired private val profileRepository: ProfileRepository,
    @Autowired private val profileHelper: ProfileHelper) : ProfileService {

  companion object {
    private const val MY_ID = "WENDY_YANTO"
  }

  override fun getProfile(): Profile {
    return profileRepository.findById(MY_ID)
        .orElseThrow { DataNotFoundException(ErrorCode.PROFILE_NOT_FOUND) }
  }

  override fun updateProfile(updateProfileRequest: UpdateProfileRequest): Profile {
    val profile = profileRepository.findById(MY_ID)
        .orElseThrow { DataNotFoundException(ErrorCode.PROFILE_NOT_FOUND) }

    return profileRepository.save(profileHelper.updateToProfile(profile, updateProfileRequest))
  }
}