package com.dev.wendyyanto.personalweb.service

import com.dev.wendyyanto.personalweb.model.dto.ArticleDTO

interface ArticleService {

  fun getArticles(): List<ArticleDTO>
}