package com.thoughtworks.people.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate
import java.time.Period
import java.util.*

@Entity
data class Person(
    @Id val id: UUID = UUID.randomUUID(),
    @NotEmpty
    val firstName: String,

    @NotEmpty
    val secondName: String,
    @JsonIgnore
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