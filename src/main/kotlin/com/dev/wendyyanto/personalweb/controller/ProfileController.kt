package com.dev.wendyyanto.personalweb.controller

import com.dev.wendyyanto.personalweb.helper.ProfileHelper
import com.dev.wendyyanto.personalweb.model.request.UpdateProfileRequest
import com.dev.wendyyanto.personalweb.model.response.BaseResponse
import com.dev.wendyyanto.personalweb.model.response.ProfileResponse
import com.dev.wendyyanto.personalweb.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileController constructor(@Autowired private val profileService: ProfileService,
                                    @Autowired private val profileHelper: ProfileHelper) : BaseController() {

  @GetMapping("/profile")
  fun getProfile(): BaseResponse<ProfileResponse> {
    val profile = profileHelper.toProfileResponse(
        profileService.getProfile())
    return toBaseResponse(profile)
  }

  @PutMapping("/profile")
  fun updateProfile(@RequestBody updateProfileRequest: UpdateProfileRequest): ProfileResponse {
    profileHelper.validateUpdateProfileRequest(updateProfileRequest)

    return profileHelper.toProfileResponse(
        profileService.updateProfile(updateProfileRequest)
    )
  }
}