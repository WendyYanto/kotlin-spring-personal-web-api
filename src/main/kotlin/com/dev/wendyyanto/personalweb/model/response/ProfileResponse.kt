package com.dev.wendyyanto.personalweb.model.response

data class ProfileResponse(
    val name: String,

    val description: String,

    val fullDescription: String,

    val profileImageUrl: String,

    val contact: ContactResponse? = null)

data class ContactResponse(
    val email: String,

    val instagramLink: String,

    val linkedinLink: String,

    val githubLink: String
)