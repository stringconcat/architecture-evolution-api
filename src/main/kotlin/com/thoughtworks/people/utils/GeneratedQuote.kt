package com.thoughtworks.people.utils

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

const val defaultQuote = "whoops, something went wrong"

class GeneratedQuote {

    private val getRandomUrl = "https://zenquotes.io/api/random"


    fun get(): String = RestTemplate()
        .exchange(
            getRandomUrl,
            HttpMethod.GET,
            null,
            object : ParameterizedTypeReference<List<QuoteResponse>>() {}
        )
        .body?.first()?.q ?: defaultQuote


    internal data class QuoteResponse(
        val h: String,
        val q: String,
        val a: String
    )
}