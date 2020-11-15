package com.pedrocomitto.mwallet.resolver

import com.pedrocomitto.mwallet.response.AssetResponse

interface AssetPriceResolver {

    fun calculate(assetResponses: List<AssetResponse>)
}