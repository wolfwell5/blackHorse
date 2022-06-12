package com.blackhorse

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AirplaneTicketApp

fun main(args: Array<String>) {
    SpringApplication.run(AirplaneTicketApp::class.java, *args)
}
