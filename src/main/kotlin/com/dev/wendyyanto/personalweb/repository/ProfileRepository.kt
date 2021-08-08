package com.dev.wendyyanto.personalweb.repository

import com.dev.wendyyanto.personalweb.model.entity.Profile
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository: MongoRepository<Profile, String>