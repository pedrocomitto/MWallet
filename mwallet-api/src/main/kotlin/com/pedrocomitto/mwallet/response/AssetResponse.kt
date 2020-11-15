package com.pedrocomitto.mwallet.response

import com.pedrocomitto.mwallet.domain.enumeration.AssetCategoryEnum
import com.pedrocomitto.mwallet.domain.enumeration.BrokerEnum
import com.pedrocomitto.mwallet.domain.enumeration.CountryEnum
import java.io.Serializable
import java.math.BigDecimal

data class AssetResponse(

    val id: Long,

    val ticker: String,

    val broker: BrokerEnum,

    val country: CountryEnum,

    val quantity: Int,

    val category: AssetCategoryEnum,

    var currentPrice: BigDecimal = BigDecimal.ZERO,

    var currentTotalValue: BigDecimal = BigDecimal.ZERO
) : Serializable