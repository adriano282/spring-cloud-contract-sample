# spring-cloud-contract-sample

Contract Driven API Development: Study Project about Spring Cloud Contract. 

The sample code is a simple Service that consumes other Service using defined communication contracts for doing isolated integration tests.


# Projects: 

Creditcardservice is the consumer service side.

Creditcheckservice is the provider service side.

Centralized-contract-repo is where the contracts were put.


# Contracts

The contracts are DSL files written in Groovy. They define the expected provider service return when a mapped request is received.
It is covered REST API and Messages communication sample tests.

# Other info

Although in the reference course was used Java, these projects were written using Kotlin programming language.

The Spring lib that enables the use of contracts is Spring Cloud Contract: https://cloud.spring.io/spring-cloud-contract/

Course Reference: https://app.pluralsight.com/library/courses/spring-cloud-contract-introduction
