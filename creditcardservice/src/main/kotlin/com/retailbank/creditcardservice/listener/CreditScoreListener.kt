package com.retailbank.creditcardservice.listener

import com.retailbank.creditcardservice.gateway.CreditCheckResponse
import com.retailbank.creditcardservice.repo.CreditScoreRepository
import com.sun.istack.internal.logging.Logger
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
class CreditScoreListener(val creditScoreRepository: CreditScoreRepository) {

    @StreamListener(Sink.INPUT)
    fun receiveScore(creditCheckResponse: CreditCheckResponse) {

        Logger.getLogger(CreditScoreListener::class.java).info("Passed here: ${creditCheckResponse.uuid}, ${creditCheckResponse.score}" )
        creditScoreRepository.save(creditCheckResponse.uuid, creditCheckResponse.score)
    }

}