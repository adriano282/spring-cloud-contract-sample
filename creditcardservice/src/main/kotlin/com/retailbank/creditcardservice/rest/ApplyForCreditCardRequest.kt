package com.retailbank.creditcardservice.rest

import java.util.*

data class ApplyForCreditCardRequest(var citizenNumber: Int, var cardType: CardType, var uuid:String = UUID.randomUUID().toString())
enum class CardType { GOLD }