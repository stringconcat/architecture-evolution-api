package com.thoughtworks.people.avatarsDiceBear

import com.thoughtworks.people.businessPeople.AvatarProvider
import com.thoughtworks.people.businessPeople.Person
import jakarta.inject.Named
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Named
class DiceBearAvatarProvider: AvatarProvider {
    override fun createForPerson(person: Person): String {
        val uniqueValue = person.firstName + person.secondName
        return "https://api.dicebear.com/10.x/pixel-art/svg" +
                "?seed=${URLEncoder.encode(uniqueValue, StandardCharsets.UTF_8)}" +
                when (person.sex) {
                    Person.Sex.MAN -> "&hairVariant=${variants("short", 24)}"
                    Person.Sex.WOMAN -> "&hairVariant=${variants("long", 21)}&beardProbability=0"
                }
    }

    // pixel-art has no gender option since DiceBear v5, so pick hair variants instead
    private fun variants(prefix: String, count: Int): String =
            (1..count).joinToString(",") { prefix + it.toString().padStart(2, '0') }

}
