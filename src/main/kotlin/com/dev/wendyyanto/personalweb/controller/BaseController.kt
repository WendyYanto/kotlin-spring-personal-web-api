package com.dev.wendyyanto.personalweb.controller

import com.dev.wendyyanto.personalweb.model.response.BaseResponse

open class BaseController {

  fun <T> toBaseResponse(data: T, message: String = "Ok"): BaseResponse<T> {
    return BaseResponse(data, message)
  }
}