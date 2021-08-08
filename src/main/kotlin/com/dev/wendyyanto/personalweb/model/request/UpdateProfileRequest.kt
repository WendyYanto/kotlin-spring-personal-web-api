package com.dev.wendyyanto.personalweb.model.request


data class UpdateProfileRequest(
    val name: String? = null,

    val description: String? = null,

    val fullDescription: String? = null,

    val profileImageUrl: String? = null,

    val contact: ContactRequest? = null)

data class ContactRequest(
    val email: String? = null,

    val instagramLink: String? = null,

    val linkedinLink: String? = null,

    val githubLink: String? = null)