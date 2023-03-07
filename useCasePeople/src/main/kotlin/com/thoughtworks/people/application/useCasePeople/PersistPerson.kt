package com.thoughtworks.people.application.useCasePeople

import com.thoughtworks.people.businessPeople.Person

interface PersistPerson {

    fun persist(person: Person)
}