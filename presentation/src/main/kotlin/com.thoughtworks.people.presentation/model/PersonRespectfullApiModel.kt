package com.thoughtworks.people.presentation.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.thoughtworks.people.businessPeople.Person

class PersonRespectfullApiModel(
        private val person: Person
) {

    @JsonProperty("title")
    fun title() =
            "${prefixIfNeeded()} ${person.firstName} ${person.secondName}"

    private fun prefixIfNeeded() =
            if (person.age() > 40)
                when (person.sex) {
                    Person.Sex.MAN -> "Mr"
                    Person.Sex.WOMAN -> "Mrs"
                }
            else ""


    @JsonProperty("avatarUrl")
    fun avatarUrl() = person.avatartUrl

    @JsonProperty("birthDay")
    fun birthDate() = "${person.birthDate.month} ${person.birthDate.year}"

    @JsonProperty("favoriteQuote")
    fun favoriteQuote() = person.favoriteQuote
}