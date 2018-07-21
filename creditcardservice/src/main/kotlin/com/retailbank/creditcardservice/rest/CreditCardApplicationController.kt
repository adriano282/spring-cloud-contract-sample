package com.retailbank.creditcardservice.rest

import com.retailbank.creditcardservice.service.CreditCheckService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreditCardApplicationController(var creditCheckService: CreditCheckService) {

    @PostMapping("/credit-card-application")
    fun applyForCreditCard(@RequestBody applyForCreditCardRequest : ApplyForCreditCardRequest) : ApplyForCreditCardResponse {
        return creditCheckService.doCreditCheckForCitizen(applyForCreditCardRequest)
    }
}