package com.pedrocomitto.mwallet.strategy.financialoperation

object Application : FinancialOperation {

    override fun updateQuantity(currentQuantity: Int, recordQuantity: Int) =
        currentQuantity + recordQuantity

}