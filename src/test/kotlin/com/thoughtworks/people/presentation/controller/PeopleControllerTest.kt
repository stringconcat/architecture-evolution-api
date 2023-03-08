package com.thoughtworks.people.controller

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
internal class PeopleControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun testMy() {
        val expectedBirthdate = "DECEMBER 1987"
        val expectedQuote = "make the easy things easy, and the hard things possible"

        mvc.perform(get("/me")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.favoriteQuote").value(expectedQuote))
            .andExpect(jsonPath("$.birthday").value(expectedBirthdate))
            .andExpect(jsonPath("$.gender").value("MAN"))
            .andExpect(jsonPath("$.title").value("Sergey Bukharov"))
            .andDo(MockMvcResultHandlers.print())

    }
}
