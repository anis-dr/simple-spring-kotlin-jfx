package me.dragan.kotlinspringjfx

import javafx.application.Application
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class SpringApplication

fun main(args: Array<String>) {
    Application.launch(JavaFXApplication::class.java, *args)
}
