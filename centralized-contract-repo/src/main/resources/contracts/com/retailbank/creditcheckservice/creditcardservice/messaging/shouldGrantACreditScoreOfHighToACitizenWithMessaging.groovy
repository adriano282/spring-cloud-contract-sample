import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("score_of_high")
    input {
        triggeredBy('scoreOfHigh()')
    }
    outputMessage {
        sentTo("credit_scores")
        body(
                score: "HIGH",
                uuid: "a15bec31-76ef-47d8-b8da-8262564a621b"
        )
        headers {
            header("contentType",  applicationJsonUtf8())
        }
    }
}