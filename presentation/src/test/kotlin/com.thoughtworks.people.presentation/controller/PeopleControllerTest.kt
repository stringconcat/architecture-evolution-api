package com.thoughtworks.people.presentation.controller

import com.thoughtworks.people.application.useCasePeople.CreateNewPersonUseCase
import com.thoughtworks.people.application.useCasePeople.GetPerson
import com.thoughtworks.people.application.useCasePeople.GetPersonUseCase
import com.thoughtworks.people.application.useCasePeople.MeUseCase
import com.thoughtworks.people.businessPeople.Person
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

@SpringBootTest(classes = [PeopleControllerTest.FakeConfig::class])
@AutoConfigureMockMvc
internal class PeopleControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    @Disabled
    fun testMy() {
        val expectedBirthdate = "1987-12-01"
        val expectedQuote = "make the easy things easy, and the hard things possible"

        mvc.perform(
            get("/me")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.favoriteQuote").value(expectedQuote))
            .andExpect(jsonPath("$.birthDate").value(expectedBirthdate))
            .andExpect(jsonPath("$.gender").value("MAN"))
            .andDo(print())
    }

    @ComponentScan("com.thoughtworks.people.presentation")
    public class FakeConfig {

        @Bean
        fun getPersonUseCase() = GetPersonUseCase {
                _ -> Person(
                    firstName = "Sergey",
                    secondName = "Bukharov",
                    sex = Person.Sex.MAN,
                    favoriteQuote = "make the easy things easy, and the hard things possible",
                    birthDate = LocalDate.of(1987, 12, 1)
            )}

        @Bean
        fun createNewPersonUseCase() = CreateNewPersonUseCase {
                _ -> Person(
            firstName = "Sergey",
            secondName = "Bukharov",
            sex = Person.Sex.MAN,
            favoriteQuote = "make the easy things easy, and the hard things possible",
            birthDate = LocalDate.of(1987, 12, 1))
        }

        @Bean
        fun meUseCase() = MeUseCase { Person(
            firstName = "Sergey",
            secondName = "Bukharov",
            sex = Person.Sex.MAN,
            favoriteQuote = "make the easy things easy, and the hard things possible",
            birthDate = LocalDate.of(1987, 12, 1))
        }
    }
}
