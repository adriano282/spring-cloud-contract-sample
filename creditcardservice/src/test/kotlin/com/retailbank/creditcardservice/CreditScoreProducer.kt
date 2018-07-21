package com.retailbank.creditcardservice

import com.retailbank.creditcardservice.gateway.CreditCheckRequest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class CreditScoreProducer(val source: Source) {
    fun requestScore(creditCheckRequest: CreditCheckRequest) {
        source.output().send(MessageBuilder.withPayload(creditCheckRequest).build())
    }

}
