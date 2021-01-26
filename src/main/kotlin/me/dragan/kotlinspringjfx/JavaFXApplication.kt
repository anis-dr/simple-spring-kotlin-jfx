package me.dragan.kotlinspringjfx

import javafx.application.Application
import javafx.application.Platform
import javafx.stage.Stage
import me.dragan.kotlinspringjfx.event.StageReadyEvent
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext

class JavaFXApplication : Application() {
    private lateinit var applicationContext: ConfigurableApplicationContext

    override fun start(stage: Stage) {
        applicationContext.publishEvent(StageReadyEvent(stage))
    }

    override fun init() {
        applicationContext = SpringApplicationBuilder()
            .sources(SpringApplication::class.java)
            .run()
    }

    override fun stop() {
        applicationContext.close()
        Platform.exit()
    }
}
