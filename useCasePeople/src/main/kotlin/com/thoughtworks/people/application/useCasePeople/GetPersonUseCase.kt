package com.thoughtworks.people.application.useCasePeople

import com.thoughtworks.people.businessPeople.Person
import java.util.*
import javax.inject.Named

fun interface GetPersonUseCase {
    operator fun invoke(id: UUID): Person?
}
@Named
class GetPersonUseCaseImpl(
    private val getPerson: GetPerson
): GetPersonUseCase {

    override operator fun invoke(id: UUID): Person? = getPerson.get(id)
}