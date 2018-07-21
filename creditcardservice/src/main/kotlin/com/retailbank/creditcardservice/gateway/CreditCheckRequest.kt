package com.retailbank.creditcardservice.gateway

import java.time.LocalDate
import java.util.*

data class CreditCheckRequest(var citizenNumber: Int, var requestedDate:String = LocalDate.now().toString(), var uuid:String = UUID.randomUUID().toString())
