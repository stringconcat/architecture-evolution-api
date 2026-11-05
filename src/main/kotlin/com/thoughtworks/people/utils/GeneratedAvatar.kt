package com.thoughtworks.people.utils

import com.thoughtworks.people.model.Person
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

class GeneratedAvatar(
        private val sex: Person.Sex,
        private val uniqueValue: String = UUID.randomUUID().toString()
) {
    fun toUrl(): String =
            "https://api.dicebear.com/10.x/pixel-art/svg" +
                    "?seed=${URLEncoder.encode(uniqueValue, StandardCharsets.UTF_8)}" +
                    when (sex) {
                        Person.Sex.MAN -> "&hairVariant=${variants("short", 24)}"
                        Person.Sex.WOMAN -> "&hairVariant=${variants("long", 21)}&beardProbability=0"
                    }

    // pixel-art has no gender option since DiceBear v5, so pick hair variants instead
    private fun variants(prefix: String, count: Int): String =
            (1..count).joinToString(",") { prefix + it.toString().padStart(2, '0') }

}
