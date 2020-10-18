package com.company;

import com.company.controller.GameControllerImpl;
import com.company.viewcontroller.TicTacToeController;
import com.company.game.TicTacToeImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        var controller = new GameControllerImpl();
        var model = new TicTacToeImpl();

        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/tictactoe.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TicTacToeController tictactoeController = loader.getController();

        tictactoeController.init(controller,model);
        primaryStage.setTitle("TicTacToe");
        Image image = new Image(getClass().getResourceAsStream("/tictactoe_icon.png"));
        primaryStage.getIcons().add(image);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
