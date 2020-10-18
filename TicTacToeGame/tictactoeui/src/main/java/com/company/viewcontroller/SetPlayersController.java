package com.company.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SetPlayersController {

    public static void invoke(Stage primaryStage, TicTacToeController base) {

        Parent root = null;
        URL location = SetPlayersController.class.getResource("../views/setplayers.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SetPlayersController controller = loader.getController();
        controller.init(base);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Set players");
        newWindow.setScene(new Scene(root, 300, 200));

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + 100);
        newWindow.setY(primaryStage.getY() + 150);

        newWindow.show();
    }

    private TicTacToeController base;

    void init(TicTacToeController base) {
        this.base = base;
        // TODO: 18.09.20 uncomment
        //base.getEngine().getPlayer1().ifPresent((p) -> player1TF.setText(p.getName()));
        //base.getEngine().getPlayer2().ifPresent((p) -> player2TF.setText(p.getName()));
    }

    @FXML
    private TextField player1TF;

    @FXML
    private TextField player2TF;

    @FXML
    private Button setBt;

    @FXML
    void setButtonAction(ActionEvent event) {
        String p1 = player1TF.getText().trim();
        String p2 = player2TF.getText().trim();
        if (p1.equals("") || p2.equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning alert");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Players can't be undefined");

            alert.showAndWait();
        }else{
            base.getController().setPlayerNames(p1,p2);
            setBt.getScene().getWindow().hide();
        }
    }

}
