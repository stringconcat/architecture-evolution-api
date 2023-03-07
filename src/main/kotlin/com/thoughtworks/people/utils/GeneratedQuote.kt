package com.thoughtworks.people.utils

import org.springframework.web.client.RestTemplate

const val defaultQuote = "whoops, something went wrong"

class GeneratedQuote {

    private val getRandomUrl = "https://api.quotable.io/random"


    fun get() = RestTemplate()
            .getForEntity(getRandomUrl, QuoteResponse::class.java)
            .body?.content ?: defaultQuote

    internal data class QuoteResponse(
        val _id: String,
        val content: String,
        val author: String
    )
}