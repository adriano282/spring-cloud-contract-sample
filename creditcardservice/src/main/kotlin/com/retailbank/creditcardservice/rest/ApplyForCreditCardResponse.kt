package com.retailbank.creditcardservice.rest

data class ApplyForCreditCardResponse(var status: Status, var uuid:String)

enum class Status { GRANTED, DENIED }