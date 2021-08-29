package com.dev.wendyyanto.personalweb.outbound.medium

import com.dev.wendyyanto.personalweb.model.outbound.medium.MediumArticleOutboundResponse

interface MediumOutbound {

  fun getArticles(): MediumArticleOutboundResponse
}