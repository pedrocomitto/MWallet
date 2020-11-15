package com.pedrocomitto.mwallet.resolver

import com.pedrocomitto.mwallet.client.FinanceClient
import com.pedrocomitto.mwallet.response.AssetResponse
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(prefix = "finance-api", name = ["plan"], havingValue = "premium")
class PremiumAssetPriceResolver(
    private val financeClient: FinanceClient
) : AssetPriceResolver {

    override fun calculate(assetResponses: List<AssetResponse>) {
        println("calculei como premium")
    }

}