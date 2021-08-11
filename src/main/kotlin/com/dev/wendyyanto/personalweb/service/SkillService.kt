package com.dev.wendyyanto.personalweb.service

import com.dev.wendyyanto.personalweb.model.entity.Skill
import com.dev.wendyyanto.personalweb.model.request.CreateSkillRequest

interface SkillService {

  fun getSkills(): List<Skill>

  fun createSkill(request: CreateSkillRequest): Skill
}