package com.retailbank.creditcardservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.cloud.stream.messaging.Source
import org.springframework.context.annotation.Bean
import org.springframework.context.support.beans
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableBinding(Sink::class, Source::class)
class CreditcardserviceApplication {

    @Bean
    fun restTemplate() : RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    runApplication<CreditcardserviceApplication>(*args)
}

