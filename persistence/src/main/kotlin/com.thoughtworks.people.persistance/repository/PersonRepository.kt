package com.thoughtworks.people.persistance.repository

import com.thoughtworks.people.persistance.model.PersonEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository: CrudRepository<PersonEntity, UUID>