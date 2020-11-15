package com.pedrocomitto.mwallet.config

import feign.RequestInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FinanceClientConfiguration(
    @Value("\${finance-api.key}")
    private val key: String
) {

    @Bean
    fun requestInterceptor(): RequestInterceptor =
        RequestInterceptor { template -> template.query("key", key) }

}
