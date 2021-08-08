package com.dev.wendyyanto.personalweb.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "profile")
data class Profile(
    @Id
    val id: String,

    var name: String? = null,

    var description: String? = null,

    var fullDescription: String? = null,

    var profileImageUrl: String? = null,

    var contact: Contact? = null)

data class Contact(
    @Field("email")
    var email: String? = null,

    @Field("instagram")
    var instagramLink: String? = null,

    @Field("linkedin")
    var linkedinLink: String? = null,

    @Field("github")
    var githubLink: String? = null
)