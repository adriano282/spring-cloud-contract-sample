package com.retailbank.creditcardservice.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class CreditCheckGateway {

    var restTemplate: RestTemplate
    var baseUrl:String

    constructor(@Autowired restTemplate: RestTemplate,
                @Value("\${creditcheckservice.baseurl}") baseUrl: String) {

        this.restTemplate = restTemplate
        this.baseUrl = baseUrl
    }

    fun doCreditCheckForCitizen(citizenNumber : Int, uuid: String) : CreditCheckResponse? {

        val uri:String = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/credit-scores")
                .toUriString()

        return restTemplate.postForObject(uri, CreditCheckRequest(citizenNumber = citizenNumber, uuid = uuid),
                CreditCheckResponse::class.java)
    }
}