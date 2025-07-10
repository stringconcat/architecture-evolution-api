package com.thoughtworks.people.useCasePeople.ports

import com.thoughtworks.people.businessPeople.Person
import java.util.*

fun interface GetPerson {

    fun get(id: UUID): Person?
}