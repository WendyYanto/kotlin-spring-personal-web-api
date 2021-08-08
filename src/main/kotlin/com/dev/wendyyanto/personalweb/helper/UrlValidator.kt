package com.dev.wendyyanto.personalweb.helper

import com.dev.wendyyanto.personalweb.constant.ErrorCode
import com.dev.wendyyanto.personalweb.exception.ValidationException
import org.springframework.stereotype.Component

@Component
class UrlValidator {

  companion object {
    private const val HTTPS_PREFIX = "https://"
    private const val HTTP_PREFIX = "http://"

    private const val JPG = "JPG"
    private const val PNG = "PNG"
    private const val JPEG = "JPEG"
    private const val SVG = "SVG"
  }

  private val urlPrefixes = listOf(HTTPS_PREFIX, HTTP_PREFIX)
  private val imageExtensions = listOf(JPG, PNG, JPEG, SVG)

  fun validateImageUrl(imageUrl: String?) {
    if (imageUrl.isNullOrBlank()) {
      return
    }

    validateUrl(imageUrl)

    if (imageExtensions.none { imageExtension -> imageUrl.endsWith(imageExtension, ignoreCase = true) }) {
      throw ValidationException(ErrorCode.IMAGE_LINK_MUST_HAS_VALID_EXTENSION)
    }
  }

  fun validateUrl(url: String?) {
    if (url.isNullOrBlank()) {
      return
    }

    if (urlPrefixes.none { prefix -> url.startsWith(prefix, ignoreCase = true) }) {
      throw ValidationException(ErrorCode.IMAGE_LINK_MUST_HAS_VALID_PREFIX)
    }
  }
}