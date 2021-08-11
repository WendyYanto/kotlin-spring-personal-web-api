package com.dev.wendyyanto.personalweb.service.impl

import com.dev.wendyyanto.personalweb.model.entity.Skill
import com.dev.wendyyanto.personalweb.repository.SkillRepository
import com.dev.wendyyanto.personalweb.service.SkillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SkillServiceImpl constructor(
    @Autowired private val skillRepository: SkillRepository) : SkillService {

  override fun getSkills(): List<Skill> {
    return skillRepository.findAll()
  }
}