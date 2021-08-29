package com.dev.wendyyanto.personalweb.configuration

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateBean {

  @Bean
  fun provideRestTemplate(): RestTemplate {
    return RestTemplateBuilder().build()
  }
}