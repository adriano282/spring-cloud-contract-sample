package com.retailbank.creditcheckservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.cloud.stream.messaging.Source

@SpringBootApplication
@EnableBinding(Source::class, Sink::class)
open class CreditcheckserviceApplication

fun main(args: Array<String>) {
    runApplication<CreditcheckserviceApplication>(*args)
}
