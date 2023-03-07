package com.thoughtworks.people.controller

import com.thoughtworks.people.model.Person
import com.thoughtworks.people.repository.PersonRepository
import com.thoughtworks.people.utils.GeneratedAvatar
import com.thoughtworks.people.utils.GeneratedQuote
import com.thoughtworks.people.utils.toNullable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.time.LocalDate
import java.util.*

@RestController
class PeopleController(
        val personRepository: PersonRepository
) {

    @GetMapping(value = ["/me"])
    @ResponseBody
    fun me(): ResponseEntity<Person> {
        val me = Person(
                id = UUID.fromString("29f4d7e3-fd7c-4664-ad07-763326215ec4"),
                firstName = "Sergey",
                secondName = "Bukharov",
                birthDate = LocalDate.of(1987,12,1),
                sex = Person.Sex.MAN,
                avatartUrl = "https://avatars.dicebear.com/v2/male/my-somffething.svg",
                favoriteQuote = "make the easy things easy, and the hard things possible"
        )
        personRepository.save(me)
        return ResponseEntity.ok(me);
    }

    @GetMapping(value = ["/id/{id}"])
    fun get(@PathVariable id: String): ResponseEntity<Person> {
        val idUUD = try {
            UUID.fromString(id)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().build()
        }

        val person = personRepository
                .findById(idUUD).toNullable()
                ?: return ResponseEntity.badRequest().build()

        return ResponseEntity.ok(person)
    }

    @PostMapping(value = ["/generate"])
    fun create(personInput: PersonInput): ResponseEntity<String>{
        val inputSex = when(personInput.gender.lowercase()) {
            "male" -> Person.Sex.MAN
            "female" -> Person.Sex.WOMAN
            else -> Person.Sex.MAN
        }

        val generatedPerson = Person(
                firstName = personInput.firstName,
                secondName = personInput.secondName,
                birthDate = LocalDate.parse(personInput.birthDate),
                sex = inputSex,
                avatartUrl = GeneratedAvatar(
                        sex = inputSex,
                        uniqueValue = personInput.firstName + personInput.secondName).toUrl(),
                favoriteQuote = GeneratedQuote().get()
        )

        personRepository.save(generatedPerson)

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/id/${generatedPerson.id}"))
                .build()
    }

    data class PersonInput(
            val firstName: String,
            val secondName: String,
            val birthDate: String,
            val gender: String
    )
}