package com.pedrocomitto.mwallet.client

import com.pedrocomitto.mwallet.config.FinanceClientConfiguration
import com.pedrocomitto.mwallet.response.StockPriceResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "finance-api-client", url = "\${finance-api.url}", configuration = [FinanceClientConfiguration::class])
interface FinanceClient {

    @GetMapping("/stock_price")
    fun findStockPrice(@RequestParam symbol: String): StockPriceResponse

}