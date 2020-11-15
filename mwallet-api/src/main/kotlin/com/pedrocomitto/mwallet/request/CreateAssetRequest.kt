package com.pedrocomitto.mwallet.request

import com.pedrocomitto.mwallet.domain.enumeration.AssetCategoryEnum
import com.pedrocomitto.mwallet.domain.enumeration.BrokerEnum
import com.pedrocomitto.mwallet.domain.enumeration.CountryEnum

data class CreateAssetRequest(
    val ticker: String,
    val broker: BrokerEnum,
    val country: CountryEnum,
    val category: AssetCategoryEnum,
    val active: Boolean = true
)
