package com.thoughtworks.people.presentation.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.thoughtworks.people.model.Person

class PersonRespectfullApiModel(
        val person: Person
) {
    @JsonProperty("title")
    fun title() =
            "${prefixIfNeeded()}${person.firstName} ${person.secondName}"

    private fun prefixIfNeeded() =
            if (person.ageYears() > 40)
                when (person.sex) {
                    Person.Sex.MAN -> "Mr"
                    Person.Sex.WOMAN -> "Mrs"
                }
            else ""

    @JsonProperty("avatarUrl")
    fun avatarUrl() = person.avatartUrl

    @JsonProperty("birthday")
    fun birthDate() = "${person.birthDate.month} ${person.birthDate.year}"

    @JsonProperty("favoriteQuote")
    fun favoriteQuote() = person.favoriteQuote

    @JsonProperty("gender")
    fun gender() = person.sex
}