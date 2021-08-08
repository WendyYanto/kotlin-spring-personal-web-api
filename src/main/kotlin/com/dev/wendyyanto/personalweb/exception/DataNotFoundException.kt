package com.dev.wendyyanto.personalweb.exception

import com.dev.wendyyanto.personalweb.constant.ErrorCode
import java.lang.RuntimeException

class DataNotFoundException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)