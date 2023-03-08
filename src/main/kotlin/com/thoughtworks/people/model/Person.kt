package com.thoughtworks.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
        @Id val id: UUID = UUID.randomUUID(),
        val firstName: String,
        val secondName: String,
        val birthDate: LocalDate,
        @JsonProperty("gender") val sex: Sex,
        val avatartUrl: String,
        val favoriteQuote: String
) {
    enum class Sex {
        MAN, WOMAN
    }
}