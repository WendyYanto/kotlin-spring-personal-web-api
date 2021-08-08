package com.dev.wendyyanto.personalweb.advice

import com.dev.wendyyanto.personalweb.constant.ErrorCode
import com.dev.wendyyanto.personalweb.exception.DataNotFoundException
import com.dev.wendyyanto.personalweb.model.response.ErrorResponse
import com.mongodb.MongoCommandException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

  @ExceptionHandler(MongoCommandException::class)
  fun constructMongoCommandExceptionResponse(): ResponseEntity<ErrorResponse> {
    return ResponseEntity
        .status(500)
        .body(ErrorResponse(
            code = ErrorCode.DATABASE_UNSPECIFIED_ERROR.code,
            message = ErrorCode.DATABASE_UNSPECIFIED_ERROR.message
        ))
  }

  @ExceptionHandler(DataNotFoundException::class)
  fun constructDataNotFoundExceptionResponse(exception: DataNotFoundException): ResponseEntity<ErrorResponse> {
    val errorCode = exception.errorCode
    return ResponseEntity
        .status(errorCode.httpStatus)
        .body(ErrorResponse(
            code = errorCode.code,
            message = errorCode.message
        ))
  }
}