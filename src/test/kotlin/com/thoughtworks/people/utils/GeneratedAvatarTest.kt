package com.thoughtworks.people.utils

import com.thoughtworks.people.model.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GeneratedAvatarTest {

    @Test
    fun `when avatar generated for man it returns proper URL`() {
        assertEquals(
                "https://api.dicebear.com/10.x/pixel-art/svg?seed=jhondoe" +
                        "&hairVariant=short01,short02,short03,short04,short05,short06,short07,short08," +
                        "short09,short10,short11,short12,short13,short14,short15,short16," +
                        "short17,short18,short19,short20,short21,short22,short23,short24",
                GeneratedAvatar(Person.Sex.MAN, "jhondoe").toUrl()
        )
    }

    @Test
    fun `when avatar generated for female it returns proper URL`() {
        assertEquals(
                "https://api.dicebear.com/10.x/pixel-art/svg?seed=alice" +
                        "&hairVariant=long01,long02,long03,long04,long05,long06,long07," +
                        "long08,long09,long10,long11,long12,long13,long14," +
                        "long15,long16,long17,long18,long19,long20,long21" +
                        "&beardProbability=0",
                GeneratedAvatar(Person.Sex.WOMAN, "alice").toUrl()
        )
    }

    @Test
    fun `when unique value has special characters it is URL encoded`() {
        assertTrue(
                GeneratedAvatar(Person.Sex.MAN, "John Doe&x").toUrl()
                        .startsWith("https://api.dicebear.com/10.x/pixel-art/svg?seed=John+Doe%26x&")
        )
    }
}
