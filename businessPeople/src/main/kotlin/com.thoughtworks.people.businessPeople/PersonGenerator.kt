package com.thoughtworks.people.businessPeople

import jakarta.inject.Named
import java.time.LocalDate

@Named
class PersonGenerator(
        private val quoteProvider: QuotesProvider,
        private val avatarProvider: AvatarProvider
) {

    fun generate(
            firstName: String,
            secondName: String,
            birthDate: LocalDate,
            sex: Person.Sex
    ): Person =
            Person(
                    firstName = firstName,
                    secondName = secondName,
                    birthDate = birthDate,
                    sex = sex,
                    favoriteQuote = quoteProvider.randomQuote()
            ).also {
                val pictureUrl = avatarProvider.createForPerson(it)
                it.changeAvatar(pictureUrl)
            }
}