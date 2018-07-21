package com.retailbank.creditcardservice

import com.retailbank.creditcardservice.gateway.CreditCheckRequest
import com.retailbank.creditcardservice.gateway.Score
import com.retailbank.creditcardservice.repo.CreditScoreRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.StubTrigger
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.test.context.junit4.SpringRunner

import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
        ids = ["com.retailbank:creditcheckservice:+:stubs:8080"], stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class CreditcardserviceApplicationMessagingTests {

	@Autowired
	lateinit var stubTrigger: StubTrigger

	@Autowired
	lateinit var creditScoreRepository: CreditScoreRepository

	@Autowired
	lateinit var creditScoreProducer: CreditScoreProducer

	@Test
	fun shouldStoreResultOfACreditCheck() {

		// Given
		val uuid: UUID = UUID.fromString("a15bec31-76ef-47d8-b8da-8262564a621b")

		// When
		stubTrigger.trigger("score_of_high")

		// Then
		val score: Score? = creditScoreRepository.score(uuid)

		Assertions.assertThat(score).isEqualTo(Score.HIGH)


	}

	@Test
	fun shouldOutputCreditScoreWhenRequestingCreditScore() {

		// Given
        creditScoreProducer.requestScore(CreditCheckRequest(1234, uuid = "a15bec31-76ef-47d8-b8da-8262564a6212"))
		val uuid: UUID = UUID.fromString("a15bec31-76ef-47d8-b8da-8262564a6212")

		// When
		val score:Score? = creditScoreRepository.score(uuid)

		// Then
		assertThat(score).isEqualTo(Score.HIGH)
	}
}
