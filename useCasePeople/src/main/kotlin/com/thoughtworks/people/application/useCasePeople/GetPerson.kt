package com.thoughtworks.people.application.useCasePeople

import com.thoughtworks.people.businessPeople.Person
import java.util.*

fun interface GetPerson {

    fun get(id: UUID): Person?
}