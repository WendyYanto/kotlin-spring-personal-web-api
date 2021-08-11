package com.dev.wendyyanto.personalweb.controller

import com.dev.wendyyanto.personalweb.helper.SkillHelper
import com.dev.wendyyanto.personalweb.model.request.CreateSkillRequest
import com.dev.wendyyanto.personalweb.model.response.BaseResponse
import com.dev.wendyyanto.personalweb.model.response.SkillResponse
import com.dev.wendyyanto.personalweb.service.SkillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SkillController constructor(
    @Autowired private val skillService: SkillService,
    @Autowired private val skillHelper: SkillHelper) : BaseController() {

  @GetMapping("/skills")
  fun getSkills(): BaseResponse<List<SkillResponse>> {
    val skills = skillHelper.toSkillResponses(skillService.getSkills())
    return toBaseResponse(skills)
  }

  @PostMapping("/skills")
  fun createSkill(@RequestBody createSkillRequest: CreateSkillRequest): BaseResponse<SkillResponse> {
    skillHelper.validateCreateSkillRequest(createSkillRequest)

    val skill = skillHelper.toSkillResponse(skillService.createSkill(createSkillRequest))
    return toBaseResponse(skill)
  }
}