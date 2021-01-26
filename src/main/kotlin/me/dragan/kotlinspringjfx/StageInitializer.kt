package me.dragan.kotlinspringjfx

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.util.Callback
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class StageInitializer internal constructor(
    private val applicationContext: ApplicationContext,
    @Value("classpath:/mainView.fxml") private val resource: Resource,
    @Value("\${spring.application.ui.title}") private val applicationTitle: String,
) : ApplicationListener<JavaFXApplication.StageReadyEvent> {

    override fun onApplicationEvent(stageReadyEvent: JavaFXApplication.StageReadyEvent) {
        val stage: Stage = stageReadyEvent.stage
        val fxmlLoader = FXMLLoader(resource.url)
        fxmlLoader.controllerFactory = Callback {
            applicationContext.getBean(it)
        }

        val load = fxmlLoader.load<Parent>()
        stage.scene = Scene(load, 800.0, 600.0)
        stage.title = applicationTitle
        stage.show()
    }
}