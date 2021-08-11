package com.dev.wendyyanto.personalweb.constant

import org.springframework.http.HttpStatus

enum class ErrorCode(val code: String, val message: String,
                     val httpStatus: Int = HttpStatus.INTERNAL_SERVER_ERROR.value()) {

  DATABASE_UNSPECIFIED_ERROR("DATABASE_UNSPECIFIED_ERROR", "Oops, there's something wrong with the database"),

  PROFILE_NOT_FOUND("PROFILE_NOT_FOUND", "Cannot find profile", HttpStatus.NOT_FOUND.value()),

  LINK_MUST_HAS_VALID_PREFIX("LINK_MUST_HAS_VALID_PREFIX", "link should starts with https or http",
      HttpStatus.BAD_REQUEST.value()),

  IMAGE_LINK_MUST_HAS_VALID_EXTENSION("IMAGE_LINK_MUST_HAS_VALID_EXTENSION",
      "Image link should have jpg, jpeg, png and svg image extension",
      HttpStatus.BAD_REQUEST.value()),

  SKILL_NAME_SHOULD_NOT_BE_EMPTY_OR_NULL("SKILL_NAME_SHOULD_NOT_BE_EMPTY_OR_NULL",
      "Skill name should not be empty or null",
      HttpStatus.BAD_REQUEST.value()),

  SKILL_RATING_INVALID_REQUEST("SKILL_RATING_INVALID_REQUEST",
      "Skill rating should be between 0 - 100",
      HttpStatus.BAD_REQUEST.value()),
}