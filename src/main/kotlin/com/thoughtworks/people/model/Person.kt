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
    @JsonIgnore
    @NotEmpty
    val firstName: String,
    @JsonIgnore
    @NotEmpty
    val secondName: String,
    @JsonIgnore
    val birthDate: LocalDate,
    @JsonProperty("gender")
    val sex: Sex,
    @NotEmpty
    val avatarUrl: String,
    @NotEmpty
    val favoriteQuote: String
) {
    enum class Sex {
        MAN, WOMAN
    }

    @JsonProperty("title")
    fun title(): String {
        val prefix = if (Period.between(LocalDate.now(), birthDate).years > 40) {
            when (sex) {
                Sex.MAN -> "Mr. "
                Sex.WOMAN -> "Mrs. "
            }
        } else {
            ""
        }

        return "$prefix$firstName $secondName"
    }

    @JsonProperty("birthday")
    fun birthday() = "${birthDate.month.name} ${birthDate.year}"
}