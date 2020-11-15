package com.pedrocomitto.mwallet.client

import com.pedrocomitto.mwallet.response.StockPriceResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "finance-api-client", url = "\${finance-api.url}")
interface FinanceClient {

    @GetMapping("/stock_price?key=$KEY")
    fun findStockPrice(@RequestParam symbol: String): StockPriceResponse

    companion object {
        const val KEY: String = "e73c6da0"
    }
}