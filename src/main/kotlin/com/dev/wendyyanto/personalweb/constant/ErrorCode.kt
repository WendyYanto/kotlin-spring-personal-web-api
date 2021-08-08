package com.dev.wendyyanto.personalweb.constant

import org.springframework.http.HttpStatus

enum class ErrorCode(val code: String, val message: String, val httpStatus: Int = HttpStatus.INTERNAL_SERVER_ERROR.value()) {
  DATABASE_UNSPECIFIED_ERROR("DATABASE_UNSPECIFIED_ERROR", "Oops, there's something wrong with the database"),
  PROFILE_NOT_FOUND("PROFILE_NOT_FOUND", "Cannot find profile", HttpStatus.NOT_FOUND.value())
}