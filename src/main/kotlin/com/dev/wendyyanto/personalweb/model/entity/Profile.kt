package com.dev.wendyyanto.personalweb.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "profile")
class Profile(
    @Id
    val id: String,
    val name: String
)