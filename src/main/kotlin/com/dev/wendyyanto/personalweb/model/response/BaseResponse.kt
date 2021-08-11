package com.dev.wendyyanto.personalweb.model.response

data class BaseResponse<T>(

    val data: T? = null,

    val message: String)