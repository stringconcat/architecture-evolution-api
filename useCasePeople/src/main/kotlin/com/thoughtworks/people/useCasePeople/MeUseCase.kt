package com.thoughtworks.people.useCasePeople

import com.thoughtworks.people.useCasePeople.ports.PersistPerson
import com.thoughtworks.people.businessPeople.AvatarProvider
import com.thoughtworks.people.businessPeople.Person
import jakarta.inject.Named
import java.time.LocalDate
import java.util.*

fun interface MeUseCase {
    operator fun invoke(): Person
}
@Named
class MeUseCaseImpl(
        private val persistPerson: PersistPerson,
        private val avatarProvider: AvatarProvider
): MeUseCase {
    override operator fun invoke(): Person {
        val me = Person(
                id = UUID.fromString("29f4d7e3-fd7c-4664-ad07-763326215ec4"),
                firstName = "Sergey",
                secondName = "Bukharov",
                birthDate = LocalDate.of(1987,12,1),
                sex = Person.Sex.MAN,
                favoriteQuote = "make the easy things easy, and the hard things possible"
        ).also {
            it.changeAvatar(avatarProvider.createForPerson(it))
        }
        persistPerson.persist(me)
        return me
    }
}