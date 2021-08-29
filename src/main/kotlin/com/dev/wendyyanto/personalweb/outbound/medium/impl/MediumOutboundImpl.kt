package com.dev.wendyyanto.personalweb.outbound.medium.impl

import com.dev.wendyyanto.personalweb.constant.ErrorCode
import com.dev.wendyyanto.personalweb.exception.DataNotFoundException
import com.dev.wendyyanto.personalweb.model.outbound.medium.MediumArticleOutboundResponse
import com.dev.wendyyanto.personalweb.outbound.medium.MediumOutbound
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class MediumOutboundImpl constructor(
    @Autowired private val restTemplate: RestTemplate) : MediumOutbound {

  companion object {
    private const val XML_TO_JSON_API_PATH = "https://api.rss2json.com/v1/api.json"
    private const val MEDIUM_ARTICLE_API_PATH = "https://medium.com/feed/@yanto-wendy98"

    private const val RSS_URL = "rss_url"
  }

  override fun getArticles(): MediumArticleOutboundResponse {
    val uri = UriComponentsBuilder.fromHttpUrl(XML_TO_JSON_API_PATH)
        .queryParam(RSS_URL, MEDIUM_ARTICLE_API_PATH)
        .build()
        .toUri()

    return try {
      restTemplate.getForEntity(uri, MediumArticleOutboundResponse::class.java).body!!
    } catch (exception: Exception) {
      throw DataNotFoundException(ErrorCode.MEDIUM_ARTICLES_NOT_FOUND)
    }
  }
}