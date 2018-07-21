package com.retailbank.creditcheckservice.messaging

import com.retailbank.creditcheckservice.CreditCheckRequest
import com.retailbank.creditcheckservice.CreditCheckResponse
import com.retailbank.creditcheckservice.CreditCheckService
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
class CreditCheckConsumer(private val creditCardService: CreditCheckService, private val creditScoreProducer: CreditScoreProducer) {

    @StreamListener(Sink.INPUT)
    fun consume(creditCheckRequest: CreditCheckRequest) {
        var creditCheckResponse: CreditCheckResponse? = creditCardService.doCreditCheck(creditCheckRequest.citizenNumber, creditCheckRequest.uuid)

        if (creditCheckResponse != null) {
            creditScoreProducer.publishScore(creditCheckResponse)
        }

    }
}