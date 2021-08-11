package com.dev.wendyyanto.personalweb.service

import com.dev.wendyyanto.personalweb.model.entity.Skill

interface SkillService {

  fun getSkills(): List<Skill>
}