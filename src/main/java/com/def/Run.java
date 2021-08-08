package com.def;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Run extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent root;


    @Override
    public void init() throws Exception{
        springContext = SpringApplication.run(Run.class);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/stages/SignInStage.fxml"));
        loader.setControllerFactory(springContext::getBean);
        root = loader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SignIn");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws Exception{
        springContext.stop();
    }

    public static void main(String[] args) {
        launch(Run.class,args);
    }
}
