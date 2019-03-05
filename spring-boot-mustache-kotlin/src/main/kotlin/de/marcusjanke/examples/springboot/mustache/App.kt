package de.marcusjanke.examples.springboot.mustache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringBoot2KotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringBoot2KotlinApplication>(*args)
}

