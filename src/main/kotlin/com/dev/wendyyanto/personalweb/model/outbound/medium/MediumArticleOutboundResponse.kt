package com.dev.wendyyanto.personalweb.model.outbound.medium

data class MediumArticleOutboundResponse(

    val items: List<MediumArticleOutboundItemResponse>? = null
)

data class MediumArticleOutboundItemResponse(
    val title: String? = null,

    val pubDate: String? = null,

    val thumbnail: String? = null,

    val link: String? = null)