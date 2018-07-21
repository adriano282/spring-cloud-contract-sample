package com.retailbank.creditcheckservice

import java.util.*

data class CreditCheckResponse(var score:Score, var uuid: String)

enum class Score { HIGH, LOW }
