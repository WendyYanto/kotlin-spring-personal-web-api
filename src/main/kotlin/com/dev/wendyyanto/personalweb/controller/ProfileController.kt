package com.dev.wendyyanto.personalweb.controller

import com.dev.wendyyanto.personalweb.model.entity.Profile
import com.dev.wendyyanto.personalweb.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileController constructor(@Autowired private val profileService: ProfileService) {

  @GetMapping("/profile")
  fun getProfile(): Profile {
    return profileService.getProfile()
  }
}