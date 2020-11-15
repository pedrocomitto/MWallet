package com.pedrocomitto.mwallet.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.pedrocomitto.mwallet.domain.enumeration.FinancialOperationEnum
import java.math.BigDecimal
import java.time.LocalDate

data class CreateRecordRequest(

    val financialOperation: FinancialOperationEnum,

    val quantity: Int,

    val price: BigDecimal,

    @JsonFormat(pattern = "dd/MM/yyyy")
    val date: LocalDate,

    val tax: BigDecimal
)
