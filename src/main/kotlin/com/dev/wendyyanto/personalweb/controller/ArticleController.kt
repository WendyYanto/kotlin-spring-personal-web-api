package com.dev.wendyyanto.personalweb.controller

import com.dev.wendyyanto.personalweb.helper.ArticleHelper
import com.dev.wendyyanto.personalweb.model.response.ArticleResponse
import com.dev.wendyyanto.personalweb.model.response.BaseResponse
import com.dev.wendyyanto.personalweb.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController constructor(
    @Autowired private val articleService: ArticleService,
    @Autowired private val articleHelper: ArticleHelper) : BaseController() {

  @GetMapping("/articles")
  fun getArticles(): BaseResponse<List<ArticleResponse>> {
    return toBaseResponse(articleHelper.mapToArticleResponses(articleService.getArticles()))
  }
}