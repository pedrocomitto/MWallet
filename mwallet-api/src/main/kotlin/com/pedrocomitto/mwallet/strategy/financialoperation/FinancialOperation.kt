package com.pedrocomitto.mwallet.strategy.financialoperation

import com.pedrocomitto.mwallet.domain.enumeration.FinancialOperationEnum

interface FinancialOperation {

    fun updateQuantity(currentQuantity: Int, recordQuantity: Int): Int

    companion object {

        fun of(operation: FinancialOperationEnum) =
            when (operation) {
                FinancialOperationEnum.APPLICATION -> Application
                FinancialOperationEnum.REDEMPTION -> Redemption
            }

    }

}