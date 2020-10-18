package com.company;

import com.company.controllers.General;
import com.company.model.TaskableImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/general.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Home Electrical Appliances");
        primaryStage.setScene(new Scene(root, 900, 600));
        General controller = loader.getController();

        controller.init(new TaskableImpl());

        Image icon = new Image(getClass().getResourceAsStream("/main_icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
