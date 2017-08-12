/*
 * Copyright (c) 2017 Nicholas van Dyke
 *
 * This file is subject to the terms and conditions defined in 'LICENSE.md'
 */

package vandyke.siamobile.backend.models.wallet

import java.math.BigDecimal

data class TransactionOutputModel(val id: String = "",
                                  val fundtype: String = "",
                                  val maturityheight: BigDecimal = BigDecimal.ZERO,
                                  val walletaddress: Boolean = false,
                                  val relatedaddress: String = "",
                                  val value: BigDecimal = BigDecimal.ZERO)