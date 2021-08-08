package com.dev.wendyyanto.personalweb.helper

import com.dev.wendyyanto.personalweb.model.entity.Contact
import com.dev.wendyyanto.personalweb.model.entity.Profile
import com.dev.wendyyanto.personalweb.model.request.ContactRequest
import com.dev.wendyyanto.personalweb.model.request.UpdateProfileRequest
import com.dev.wendyyanto.personalweb.model.response.ContactResponse
import com.dev.wendyyanto.personalweb.model.response.ProfileResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileHelper constructor(@Autowired private val urlValidator: UrlValidator) {

  fun toProfileResponse(profile: Profile): ProfileResponse {
    return ProfileResponse(
        name = profile.name.orEmpty(),
        description = profile.description.orEmpty(),
        fullDescription = profile.fullDescription.orEmpty(),
        profileImageUrl = profile.profileImageUrl.orEmpty(),
        contact = toContactResponse(profile.contact)
    )
  }

  private fun toContactResponse(contact: Contact?): ContactResponse? {
    contact?.let { safeContact ->
      return ContactResponse(
          email = safeContact.email.orEmpty(),
          instagramLink = safeContact.instagramLink.orEmpty(),
          linkedinLink = safeContact.linkedinLink.orEmpty(),
          githubLink = safeContact.githubLink.orEmpty()
      )
    } ?: run {
      return null
    }
  }

  fun updateToProfile(profile: Profile, updateProfileRequest: UpdateProfileRequest): Profile {
    return profile.apply {
      name = updateProfileRequest.name
      description = updateProfileRequest.description
      fullDescription = updateProfileRequest.fullDescription
      profileImageUrl = updateProfileRequest.profileImageUrl
      contact = toContact(updateProfileRequest.contact)
    }
  }

  fun toContact(contact: ContactRequest?): Contact? {
    contact?.let { safeContact ->
      return Contact(
          email = safeContact.email,
          instagramLink = safeContact.instagramLink,
          linkedinLink = safeContact.linkedinLink,
          githubLink = safeContact.githubLink
      )
    } ?: run {
      return null
    }
  }

  fun validateUpdateProfileRequest(updateProfileRequest: UpdateProfileRequest) {
    urlValidator.validateImageUrl(updateProfileRequest.profileImageUrl)

    urlValidator.validateUrl(updateProfileRequest.contact?.linkedinLink)
    urlValidator.validateUrl(updateProfileRequest.contact?.instagramLink)
    urlValidator.validateUrl(updateProfileRequest.contact?.githubLink)
  }
}