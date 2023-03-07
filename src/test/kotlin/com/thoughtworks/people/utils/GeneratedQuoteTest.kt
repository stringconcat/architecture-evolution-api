package com.thoughtworks.people.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GeneratedQuoteTest {

    @Test
    @Disabled
    fun `random quote should be received`() {
        val obtainedQuoute = GeneratedQuote().get()
        assertTrue(obtainedQuoute.isNotEmpty())
        assertNotEquals(defaultQuote, obtainedQuoute)
    }
}