package com.pedrocomitto.mwallet.strategy.financialoperation

object Redemption : FinancialOperation {

    override fun updateQuantity(currentQuantity: Int, recordQuantity: Int) =
        currentQuantity - recordQuantity

}