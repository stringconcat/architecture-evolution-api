package com.thoughtworks.people.controller

import com.thoughtworks.people.model.Person
import com.thoughtworks.people.service.PersonInput
import com.thoughtworks.people.service.PersonsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
class PeopleController(
        val personService: PersonsService
) {

    @GetMapping(value = ["/me"])
    @ResponseBody
    fun me(): ResponseEntity<Person> {
        val me = personService.me()
        return ResponseEntity.ok(me)
    }

    @GetMapping(value = ["/id/{id}"])
    fun get(@PathVariable id: String): ResponseEntity<Person> {
        val idUUD = try {
            UUID.fromString(id)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().build()
        }

        val person = personService.get(idUUD)
                ?: return ResponseEntity.badRequest().build()

        return ResponseEntity.ok(person)
    }

    @PostMapping(value = ["/generate"])
    fun create(personInput: PersonInput): ResponseEntity<String>{
        val generatedPerson = personService.createNewPerson(personInput)

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/id/${generatedPerson.id}"))
                .build()
    }
}