package com.retailbank.creditcheckservice

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import sun.reflect.generics.reflectiveObjects.NotImplementedException

@Service
open class CreditCheckService {
    open fun doCreditCheck(citizenNumber: Int, uuid: String): CreditCheckResponse {
        throw NotImplementedException()
    }
}
