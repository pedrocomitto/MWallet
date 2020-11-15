package com.pedrocomitto.mwallet.resolver

import com.pedrocomitto.mwallet.client.FinanceClient
import com.pedrocomitto.mwallet.response.AssetResponse
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
@ConditionalOnProperty(prefix = "finance-api", name = ["plan"], havingValue = "free")
class FreeAssetPriceResolver(
    private val financeClient: FinanceClient
) : AssetPriceResolver {

    override fun calculate(assetResponses: List<AssetResponse>) =
        assetResponses.forEach {
            it.currentPrice = financeClient.findStockPrice(it.ticker)
                .results[it.ticker]
                ?.price ?: BigDecimal.ZERO

            it.currentTotalValue = it.currentPrice
                .multiply(BigDecimal(it.quantity))
        }


}