import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("score_of_high_input_output")
    input {
        messageFrom("credit_scores_request")
        messageBody(
                citizenNumber : 1234,
                uuid : $(c(regex(uuid())), p("a15bec31-76ef-47d8-b8da-8262564a6212"))
        )
    }

    outputMessage {
        sentTo("credit_scores")
        body(
                score: "HIGH",
                uuid: "a15bec31-76ef-47d8-b8da-8262564a6212"
        )
        headers {
            header("contentType",  applicationJsonUtf8())
        }
    }
}