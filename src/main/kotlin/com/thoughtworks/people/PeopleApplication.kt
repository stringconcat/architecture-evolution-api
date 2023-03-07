package com.thoughtworks.people

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PeopleApplication

fun main(args: Array<String>) {
	runApplication<PeopleApplication>(*args)
}
