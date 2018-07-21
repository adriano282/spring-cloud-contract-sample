package com.retailbank.creditcheckservice

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreditCheckController(var creditCheckService: CreditCheckService) {


    @PostMapping("/credit-scores")
    fun doCreditCheck(@RequestBody request: CreditCheckRequest) : CreditCheckResponse {
        return creditCheckService.doCreditCheck(request.citizenNumber, request.uuid)
    }
}
