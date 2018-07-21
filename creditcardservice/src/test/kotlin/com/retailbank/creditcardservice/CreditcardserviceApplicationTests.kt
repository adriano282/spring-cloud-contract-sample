package com.retailbank.creditcardservice

import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
        ids = ["com.retailbank:creditcheckservice:+:stubs:8080"])
class CreditcardserviceApplicationTests {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun shouldGrantApplicationWhenCreditScoreisHigh() {
		var bodyRequest:String = "{ \"citizenNumber\":1234, \"cardType\": \"GOLD\"}"

		mockMvc.perform(
				MockMvcRequestBuilders
						.post("/credit-card-application")
						.contentType(MediaType.APPLICATION_JSON)
						.content(bodyRequest)

		)
				.andDo { println() }
				.andExpect(MockMvcResultMatchers.status().isOk)
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("GRANTED"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.uuid").value(CoreMatchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	}

    @Test
    fun shouldGrantApplicationWhenCreditScoreisLow() {
        var bodyRequest:String = "{ \"citizenNumber\":4444, \"cardType\": \"GOLD\"}"

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/credit-card-application")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyRequest)

        )
                .andDo { println() }
                .andExpect(MockMvcResultMatchers.status().isOk)
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("DENIED"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.uuid").value(CoreMatchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
    }

}
