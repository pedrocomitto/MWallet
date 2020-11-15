package com.pedrocomitto.mwallet.response

import java.math.BigDecimal

data class StockPriceResponse(
    val results: Map<String, TickerResponse>
)

data class TickerResponse(
    val price: BigDecimal?
)
