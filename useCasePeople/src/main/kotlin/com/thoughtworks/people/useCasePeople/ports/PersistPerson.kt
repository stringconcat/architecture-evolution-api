package com.thoughtworks.people.useCasePeople.ports

import com.thoughtworks.people.businessPeople.Person

interface PersistPerson {

    fun persist(person: Person)
}