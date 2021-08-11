package com.dev.wendyyanto.personalweb.repository

import com.dev.wendyyanto.personalweb.model.entity.Skill
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SkillRepository : MongoRepository<Skill, String>