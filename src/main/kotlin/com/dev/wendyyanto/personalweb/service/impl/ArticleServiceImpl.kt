package com.dev.wendyyanto.personalweb.service.impl

import com.dev.wendyyanto.personalweb.helper.ArticleHelper
import com.dev.wendyyanto.personalweb.model.dto.ArticleDTO
import com.dev.wendyyanto.personalweb.outbound.medium.MediumOutbound
import com.dev.wendyyanto.personalweb.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl constructor(
    @Autowired private val mediumOutbound: MediumOutbound,
    @Autowired private val articleHelper: ArticleHelper) : ArticleService {

  override fun getArticles(): List<ArticleDTO> {
    val mediumArticles = mediumOutbound.getArticles()
    return articleHelper.mapToArticleDTOs(mediumArticles)
  }
}