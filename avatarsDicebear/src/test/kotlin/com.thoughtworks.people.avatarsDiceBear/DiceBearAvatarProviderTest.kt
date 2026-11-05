package com.thoughtworks.people.avatarsDiceBear

import com.thoughtworks.people.businessPeople.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class DiceBearAvatarProviderTest {

    @Test
    fun `when avatar generated for man it returns proper URL`() {
        assertEquals(
                "https://api.dicebear.com/10.x/pixel-art/svg?seed=JohnDoe" +
                        "&hairVariant=short01,short02,short03,short04,short05,short06,short07,short08," +
                        "short09,short10,short11,short12,short13,short14,short15,short16," +
                        "short17,short18,short19,short20,short21,short22,short23,short24",
                DiceBearAvatarProvider().createForPerson(person("John", "Doe", Person.Sex.MAN))
        )
    }

    @Test
    fun `when avatar generated for female it returns proper URL`() {
        assertEquals(
                "https://api.dicebear.com/10.x/pixel-art/svg?seed=AliceSmith" +
                        "&hairVariant=long01,long02,long03,long04,long05,long06,long07," +
                        "long08,long09,long10,long11,long12,long13,long14," +
                        "long15,long16,long17,long18,long19,long20,long21" +
                        "&beardProbability=0",
                DiceBearAvatarProvider().createForPerson(person("Alice", "Smith", Person.Sex.WOMAN))
        )
    }

    @Test
    fun `when name has special characters it is URL encoded`() {
        assertTrue(
                DiceBearAvatarProvider().createForPerson(person("John Doe", "&x", Person.Sex.MAN))
                        .startsWith("https://api.dicebear.com/10.x/pixel-art/svg?seed=John+Doe%26x&")
        )
    }

    private fun person(firstName: String, secondName: String, sex: Person.Sex) =
            Person(
                    firstName = firstName,
                    secondName = secondName,
                    birthDate = LocalDate.of(1990, 1, 15),
                    sex = sex,
                    favoriteQuote = "who knows?"
            )
}
