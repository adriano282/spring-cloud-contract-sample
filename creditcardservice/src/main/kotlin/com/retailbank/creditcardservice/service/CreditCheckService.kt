package com.retailbank.creditcardservice.service

import com.retailbank.creditcardservice.rest.ApplyForCreditCardRequest
import com.retailbank.creditcardservice.rest.ApplyForCreditCardResponse
import com.retailbank.creditcardservice.rest.CardType
import com.retailbank.creditcardservice.rest.Status
import com.retailbank.creditcardservice.gateway.CreditCheckGateway
import com.retailbank.creditcardservice.gateway.Score
import org.springframework.stereotype.Component

@Component
class CreditCheckService(val creditCheckGateway: CreditCheckGateway) {

    fun doCreditCheckForCitizen(applyForCreditCardRequest: ApplyForCreditCardRequest) : ApplyForCreditCardResponse {

        val citizenNumber: Int = applyForCreditCardRequest.citizenNumber
        val uuid: String = applyForCreditCardRequest.uuid

        var response = creditCheckGateway.doCreditCheckForCitizen(citizenNumber, uuid)

        if (response?.uuid != applyForCreditCardRequest.uuid) {
            throw RuntimeException("If these don't match someting horrible happen.")
        }

        if (applyForCreditCardRequest.cardType == CardType.GOLD) {

            return when(response.score) {
                Score.HIGH ->
                    ApplyForCreditCardResponse(Status.GRANTED, response.uuid)

                Score.LOW ->
                    ApplyForCreditCardResponse(Status.DENIED, response.uuid)
            }
        }

        throw RuntimeException("Card and score not yet implemented")
    }
}