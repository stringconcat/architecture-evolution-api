package com.thoughtworks.people.application.businessPeople.quotes

import com.thoughtworks.people.businessPeople.Quote
import com.thoughtworks.people.businessPeople.QuotesProvider

class EmptyQuoteProviders: QuotesProvider {
    override fun randomQuote(): Quote = ""
}