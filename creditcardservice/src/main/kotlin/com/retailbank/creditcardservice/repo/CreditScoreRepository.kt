package com.retailbank.creditcardservice.repo

import com.retailbank.creditcardservice.gateway.Score
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.HashMap

@Component
class CreditScoreRepository {

    val creditScores: HashMap<String, Score> = HashMap()

    fun score(uuid: UUID): Score? {
        return creditScores[uuid.toString()]
    }

    fun save(uuid: String, score: Score) {
        creditScores[uuid] = score
    }

}

