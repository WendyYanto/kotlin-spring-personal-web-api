package com.dev.wendyyanto.personalweb.helper

import com.dev.wendyyanto.personalweb.constant.ErrorCode
import com.dev.wendyyanto.personalweb.exception.ValidationException
import com.dev.wendyyanto.personalweb.model.entity.Skill
import com.dev.wendyyanto.personalweb.model.request.CreateSkillRequest
import com.dev.wendyyanto.personalweb.model.response.SkillResponse
import org.springframework.stereotype.Component

@Component
class SkillHelper {

  companion object {
    const val MIN_SKILL_RATING = 0
    const val MAX_SKILL_RATING = 100
  }

  fun toSkillResponses(skills: List<Skill>): List<SkillResponse> {
    return skills.map(::toSkillResponse)
  }

  fun toSkillResponse(skill: Skill): SkillResponse {
    return SkillResponse(
        name = skill.name.orEmpty(),
        rating = skill.rating.orZero()
    )
  }

  fun validateCreateSkillRequest(request: CreateSkillRequest) {
    if (request.name.isNullOrBlank()) {
      throw ValidationException(ErrorCode.SKILL_NAME_SHOULD_NOT_BE_EMPTY_OR_NULL)
    }
    val rating = request.rating.orZero()
    if (rating < MIN_SKILL_RATING || rating > MAX_SKILL_RATING) {
      throw ValidationException(ErrorCode.SKILL_RATING_INVALID_REQUEST)
    }
  }
}