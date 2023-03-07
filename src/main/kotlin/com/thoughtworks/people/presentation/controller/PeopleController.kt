package com.thoughtworks.people.presentation.controller

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

    @RequestMapping(value = ["/me"], method = [RequestMethod.GET])
    fun me(): ResponseEntity<Person> {
        val me = personService.me()
        return ResponseEntity.ok(me)
    }

    @RequestMapping(value = ["/id/{id}"])
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

    @RequestMapping(value = ["/generate"], method = [RequestMethod.POST] )
    @ResponseBody
    fun create(personInput: PersonInput): ResponseEntity<String>{
        val generatedPerson = personService.createNewPerson(personInput)

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/id/${generatedPerson.id}"))
                .build()
    }
}