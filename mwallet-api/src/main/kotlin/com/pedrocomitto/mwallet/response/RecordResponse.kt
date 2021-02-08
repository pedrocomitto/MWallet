package com.pedrocomitto.mwallet.response

import com.pedrocomitto.mwallet.domain.enumeration.FinancialOperationEnum
import java.math.BigDecimal
import java.time.LocalDate

data class RecordResponse(

    val id: Long,

    val financialOperation: FinancialOperationEnum,

    val asset: String,

    val quantity: Int,

    val price: BigDecimal,

    val date: LocalDate,

    val tax: BigDecimal,

    var value: BigDecimal
)