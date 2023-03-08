package com.thoughtworks.people.model

import java.time.LocalDate
import java.time.Period
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotEmpty

@Entity
data class Person(
        @Id val id: UUID = UUID.randomUUID(),
        @NotEmpty
        val firstName: String,
        @NotEmpty
        val secondName: String,
        val birthDate: LocalDate,
        val sex: Sex,
        @NotEmpty
        val avatartUrl: String,
        @NotEmpty
        val favoriteQuote: String
) {
    enum class Sex {
        MAN, WOMAN
    }

    fun ageYears() = Period.between(birthDate, LocalDate.now()).years
}