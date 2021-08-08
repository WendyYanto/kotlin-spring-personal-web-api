package com.dev.wendyyanto.personalweb.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "profile")
data class Profile(
    @Id
    val id: String,
    val name: String? = null,
    val description: String? = null,
    val fullDescription: String? = null,
    val profileImageUrl: String? = null,
    val contact: Contact? = null)

data class Contact(
    @Field("email")
    val email: String? = null,

    @Field("instagram")
    val instagramLink: String? = null,

    @Field("linkedin")
    val linkedinLink: String? = null,

    @Field("github")
    val githubLink: String? = null
)