package com.thoughtworks.people.application.useCasePeople

import com.thoughtworks.people.businessPeople.Person
import com.thoughtworks.people.businessPeople.PersonGenerator
import java.time.LocalDate
import javax.inject.Named

fun interface CreateNewPersonUseCase {
    operator fun invoke(
        personInput: PersonCreationSummary
    ): Person
}

@Named
class CreateNewPersonUseCaseImpl(
    private val persistPerson: PersistPerson,
    private val personGenerator: PersonGenerator
): CreateNewPersonUseCase {
    override operator fun invoke(
        personInput: PersonCreationSummary
    ): Person {
        val inputSex = when(personInput.gender.lowercase()) {
            "male" -> Person.Sex.MAN
            "female" -> Person.Sex.WOMAN
            else -> Person.Sex.MAN
        }

        val generatedPerson = personGenerator.generate(
            firstName = personInput.firstName,
            secondName = personInput.secondName,
            birthDate = LocalDate.parse(personInput.birthDate),
            sex = inputSex
        )

        persistPerson.persist(generatedPerson)

        // TODO Send email to user
        // TODO Add the event to event queue

        return generatedPerson
    }
}

data class PersonCreationSummary(
    val firstName: String,
    val secondName: String,
    val birthDate: String,
    val gender: String
)