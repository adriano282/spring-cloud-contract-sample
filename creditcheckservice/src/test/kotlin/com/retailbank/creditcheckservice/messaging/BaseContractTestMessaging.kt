package com.retailbank.creditcheckservice.messaging

import com.retailbank.creditcheckservice.CreditCheckResponse
import com.retailbank.creditcheckservice.CreditCheckService
import com.retailbank.creditcheckservice.CreditcheckserviceApplication
import com.retailbank.creditcheckservice.Score
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.annotation.PostConstruct

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(CreditcheckserviceApplication::class, BaseContractTestMessaging.MockConfiguration::class))
@AutoConfigureMessageVerifier
open class BaseContractTestMessaging {

    @Autowired
    lateinit var creditScoreProducer: CreditScoreProducer

    @Autowired
    lateinit var creditCheckService: CreditCheckService

    fun scoreOfHigh() {
        creditScoreProducer.publishScore(CreditCheckResponse(Score.HIGH, "a15bec31-76ef-47d8-b8da-8262564a621b"))
    }


    @PostConstruct
    fun setup() {
        Mockito.`when`(creditCheckService.doCreditCheck(1234, "a15bec31-76ef-47d8-b8da-8262564a6212"))
                .thenReturn(CreditCheckResponse(Score.HIGH, "a15bec31-76ef-47d8-b8da-8262564a6212"))
    }


    @Configuration
    open class MockConfiguration {

        @MockBean
        lateinit var creditCheckService: CreditCheckService
    }
}