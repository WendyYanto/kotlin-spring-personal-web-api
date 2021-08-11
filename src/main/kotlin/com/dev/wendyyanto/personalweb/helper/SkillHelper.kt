package com.dev.wendyyanto.personalweb.helper

import com.dev.wendyyanto.personalweb.model.entity.Skill
import com.dev.wendyyanto.personalweb.model.response.SkillResponse
import org.springframework.stereotype.Component

@Component
class SkillHelper {

  fun toSkillResponses(skills: List<Skill>): List<SkillResponse> {
    return skills.map(::toSkillResponse)
  }

  private fun toSkillResponse(skill: Skill): SkillResponse {
    return SkillResponse(
        name = skill.name.orEmpty(),
        rating = skill.rating.orZero()
    )
  }
}