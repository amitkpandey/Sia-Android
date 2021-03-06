/*
 * Copyright (c) 2017 Nicholas van Dyke. All rights reserved.
 */

package com.vandyke.sia.data.models.wallet

data class TransactionsData(
        val confirmedtransactions: List<TransactionData>?,
        val unconfirmedtransactions: List<TransactionData>?
) {
    val alltransactions: List<TransactionData>
        get() = (confirmedtransactions ?: listOf()) + (unconfirmedtransactions ?: listOf())
}