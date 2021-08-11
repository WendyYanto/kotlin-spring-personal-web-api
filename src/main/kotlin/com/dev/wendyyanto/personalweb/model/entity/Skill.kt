package com.dev.wendyyanto.personalweb.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "skill")
data class Skill(

    @Id
    val id: String? = null,

    val name: String? = null,

    val rating: Int? = null,

    val updatedDate: Long? = null
)