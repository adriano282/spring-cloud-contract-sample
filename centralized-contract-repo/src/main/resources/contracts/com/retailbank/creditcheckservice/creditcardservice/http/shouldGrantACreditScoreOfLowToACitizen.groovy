import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/credit-scores'
        body (
            "citizenNumber" : 4444,
            "requestedDate" : anyDate(),
            "uuid" : $(consumer(anyUuid()), producer("66ce29f3-ae87-4097-9436-22222222222222"))
        )
        headers {
            contentType applicationJson()
        }
    }

    response {
        status 200
        body (
            "score": "LOW",
            "uuid": $(consumer(fromRequest().body('$.uuid')), producer("66ce29f3-ae87-4097-9436-22222222222222"))
        )
        headers {
            contentType applicationJson()
        }
    }
}