package com.retailbank.creditcardservice.gateway

data class CreditCheckResponse(var score: Score, var uuid:String)

enum class Score { HIGH, LOW }