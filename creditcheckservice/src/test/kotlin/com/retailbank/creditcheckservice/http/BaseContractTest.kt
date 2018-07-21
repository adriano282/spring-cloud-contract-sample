package com.retailbank.creditcheckservice.http

import com.retailbank.creditcheckservice.CreditCheckController
import com.retailbank.creditcheckservice.CreditCheckResponse
import com.retailbank.creditcheckservice.CreditCheckService
import com.retailbank.creditcheckservice.Score
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.Before
import org.mockito.Mockito

open class BaseContractTest {

    @Before
    fun setup() {
        val creditCheckService: CreditCheckService = Mockito.mock(CreditCheckService::class.java)

        Mockito.`when`(creditCheckService.doCreditCheck(1234, "66ce29f3-ae87-4097-9436-22222222222222")).thenReturn(CreditCheckResponse(Score.HIGH, "66ce29f3-ae87-4097-9436-22222222222222"))
        Mockito.`when`(creditCheckService.doCreditCheck(4444, "66ce29f3-ae87-4097-9436-22222222222222")).thenReturn(CreditCheckResponse(Score.LOW, "66ce29f3-ae87-4097-9436-22222222222222"))

        RestAssuredMockMvc.standaloneSetup(CreditCheckController(creditCheckService))
    }
}

