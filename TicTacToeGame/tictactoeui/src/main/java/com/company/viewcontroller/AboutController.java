package com.company.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AboutController {

    public static void invoke(Stage primaryStage, TicTacToeController base) {
        Parent root = null;
        URL location = AboutController.class.getResource("../views/about.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AboutController controller = loader.getController();
        controller.init(base);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("About");
        newWindow.setScene(new Scene(root, 400, 300));

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 50);
        newWindow.setY(primaryStage.getY() + 100);

        newWindow.show();
    }

    public void  init(TicTacToeController base){

    }

    @FXML
    private Button okBt;

    @FXML
    void okButtonAction(ActionEvent event) {
        okBt.getScene().getWindow().hide();
    }

}
