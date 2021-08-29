package com.dev.wendyyanto.personalweb.helper

import com.dev.wendyyanto.personalweb.model.dto.ArticleDTO
import com.dev.wendyyanto.personalweb.model.outbound.medium.MediumArticleOutboundResponse
import com.dev.wendyyanto.personalweb.model.response.ArticleResponse
import org.springframework.stereotype.Component

@Component
class ArticleHelper {

  fun mapToArticleResponses(articles: List<ArticleDTO>): List<ArticleResponse> {
    return articles.map(::mapToArticleResponse)
  }

  fun mapToArticleResponse(article: ArticleDTO): ArticleResponse {
    return ArticleResponse(
        title = article.title,
        link = article.link,
        thumbnail = article.thumbnail,
        publishedDate = article.publishedDate
    )
  }

  fun mapToArticleDTOs(mediumArticleOutboundResponse: MediumArticleOutboundResponse): List<ArticleDTO> {
    return mediumArticleOutboundResponse.items?.map { mediumArticle ->
      ArticleDTO(
        title = mediumArticle.title.orEmpty(),
          link = mediumArticle.link.orEmpty(),
          thumbnail = mediumArticle.thumbnail.orEmpty(),
          publishedDate = mediumArticle.pubDate.orEmpty()
      )
    } ?: run {
      return emptyList()
    }
  }
}