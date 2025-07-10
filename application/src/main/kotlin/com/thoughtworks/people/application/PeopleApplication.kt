package com.thoughtworks.people.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(value = ["com.thoughtworks.people"])
@EnableJpaRepositories(basePackages = ["com.thoughtworks.people.persistance"])
@EntityScan(basePackages = ["com.thoughtworks.people.persistance"])
open class PeopleApplication

fun main(args: Array<String>) {
	runApplication<PeopleApplication>(*args)
}
