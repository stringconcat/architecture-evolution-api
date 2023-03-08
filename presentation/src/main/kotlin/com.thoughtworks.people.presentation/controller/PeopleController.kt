package com.thoughtworks.people.presentation.controller

import com.thoughtworks.people.application.useCasePeople.CreateNewPersonUseCase
import com.thoughtworks.people.application.useCasePeople.GetPersonUseCase
import com.thoughtworks.people.application.useCasePeople.MeUseCase
import com.thoughtworks.people.application.useCasePeople.PersonCreationSummary
import com.thoughtworks.people.presentation.model.PersonRespectfullApiModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class PeopleController(
    val getPerson: GetPersonUseCase,
    val createNew: CreateNewPersonUseCase,
    val getMe: MeUseCase
) {

    @GetMapping(value = ["/me"])
    fun me(): PersonRespectfullApiModel {
        return PersonRespectfullApiModel(getMe())
    }

    @GetMapping(value = ["/id/{id}"])
    fun get(@PathVariable id: String): ResponseEntity<PersonRespectfullApiModel> {
        val idUUD = try {
            UUID.fromString(id)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().build()
        }

        val person = getPerson(idUUD)
                ?: return ResponseEntity.badRequest().build()

        return ResponseEntity.ok(PersonRespectfullApiModel(person))
    }

    @PostMapping(value = ["/generate"])
    fun create(personInput: PersonCreationSummary): ResponseEntity<String>{
        val generatedPerson = createNew(personInput)

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/id/${generatedPerson.id}"))
                .build()
    }
}