package com.retailbank.creditcheckservice.messaging

import com.retailbank.creditcheckservice.CreditCheckResponse
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class CreditScoreProducer(private val source: Source) {

    fun publishScore(creditCheckResponse: CreditCheckResponse) {
        source.output().send(MessageBuilder.withPayload(creditCheckResponse).build())
    }

}
