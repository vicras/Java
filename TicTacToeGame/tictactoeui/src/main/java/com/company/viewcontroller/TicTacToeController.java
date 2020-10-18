package com.company.viewcontroller;
/**
 * Sample Skeleton for 'tictactoe.fxml' Controller Class
 */

import com.company.controller.GameController;
import com.company.engine.field.NaughtsCrosses;
import com.company.engine.field.checker.WinPosition;
import com.company.engine.state.GameStatus;
import com.company.game.TicTacToe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.util.stream.Stream;

public class TicTacToeController implements ViewInterface {

    //region field
    @FXML // fx:id="newGameBt"
    private MenuItem newGameBt; // Value injected by FXMLLoader

    @FXML // fx:id="leaderboardBt"
    private MenuItem leaderboardBt; // Value injected by FXMLLoader

    @FXML // fx:id="quitBt"
    private MenuItem quitBt; // Value injected by FXMLLoader

    @FXML // fx:id="aboutBt"
    private MenuItem aboutBt; // Value injected by FXMLLoader

    @FXML // fx:id="button0"
    private Button button0; // Value injected by FXMLLoader

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader

    @FXML // fx:id="button3"
    private Button button3; // Value injected by FXMLLoader

    @FXML // fx:id="button4"
    private Button button4; // Value injected by FXMLLoader

    @FXML // fx:id="button5"
    private Button button5; // Value injected by FXMLLoader

    @FXML // fx:id="button6"
    private Button button6; // Value injected by FXMLLoader

    @FXML // fx:id="button7"
    private Button button7; // Value injected by FXMLLoader

    @FXML // fx:id="button8"
    private Button button8; // Value injected by FXMLLoader

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader
    //endregion

    private GameController controller;
    private TicTacToe engine;
    private GameStatus currentStatus;

    public TicTacToeController() {
    }

    public void setDisable(boolean isDisable) {
        button0.setDisable(isDisable);
        button1.setDisable(isDisable);
        button2.setDisable(isDisable);
        button3.setDisable(isDisable);
        button4.setDisable(isDisable);
        button5.setDisable(isDisable);
        button6.setDisable(isDisable);
        button7.setDisable(isDisable);
        button8.setDisable(isDisable);
    }

    private void setText(String text) {
        button0.setText(text);
        button1.setText(text);
        button2.setText(text);
        button3.setText(text);
        button4.setText(text);
        button5.setText(text);
        button6.setText(text);
        button7.setText(text);
        button8.setText(text);
    }

    public void init(GameController controller, TicTacToe engine) {
        this.controller = controller;
        this.engine = engine;
        currentStatus = GameStatus.GAME_END;
        controller.init(engine, this);
        setDisable(true);
        setText("");
    }

    public GameController getController() {
        return controller;
    }

    public TicTacToe getEngine() {
        return engine;
    }


    @FXML
    void mouseClicked(ActionEvent event) {
        Button source = (Button) event.getSource();
        String id = source.getId();
        controller.move(id);
    }

    @Override
    public void stateChanged(GameStatus gameStatus) {
        currentStatus = gameStatus;
        switch (gameStatus) {
            case PLAYER_2_MOVE -> {
                infoLabel.setText("player 2 move");
            }
            case PLAYER_1_MOVE -> {
                infoLabel.setText("player 1 move");
            }
            case GAME_END -> {
                infoLabel.setText(controller.getGameResult());
                makeWinPosition(engine.getWinPosition());
                winningInformation();
                setDisable(true);
            }
        }
    }


    private void winningInformation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Result");
        alert.setHeaderText(controller.getGameResult());
        engine.getGameResult().ifPresent(gameRecord -> {alert.setContentText(gameRecord.toString());});
        alert.showAndWait();
    }

    private void makeWinPosition(WinPosition winPosition){
        if(!winPosition.isExist())
            return;
        var style ="-fx-background-color: #ff0000";
        var line = winPosition.getLine();

        switch (winPosition.getPositionVariant()){
            case MAIN_DIAGONAL -> {
                changeButtonStyle(style, 0,4,3);
                button0.setStyle(style);

            }
            case ANOTHER_DIAGONAL -> {
                changeButtonStyle(style,2,2,3);
            }
            case VERTICAL -> {
                changeButtonStyle(style, line, 3,3);
            }
            case HORIZONTAL -> {
                changeButtonStyle(style,(line *3), 1,3);
            }
        }


    }
    private void changeButtonStyle(String style, int seed, int add, int limit){
        Stream.iterate(seed, i ->  i + add)
                .limit(limit)
                .forEach(e -> {
                    Button lookup = (Button) button0.getScene().lookup("#button" + e);
                    lookup.setStyle(style);
                });
    }
    @FXML
    void aboutAction(ActionEvent event) {
        AboutController.invoke((Stage) button0.getScene().getWindow(), this);
    }

    @FXML
    void leaderboardAction(ActionEvent event) {
        LeaderboardController.invoke((Stage) button0.getScene().getWindow(), this);
    }

    @FXML
    void newGameAction(ActionEvent event) {
        controller.newGame();
    }

    @FXML
    void quitAction(ActionEvent event) {
        button0.getScene().getWindow().hide();
    }

    @Override
    @FXML
    public void setPlayersAction() {
        SetPlayersController.invoke((Stage) button0.getScene().getWindow(), this);
    }

    @Override
    public void updateButton(String button, NaughtsCrosses state) {
        Button lookup = (Button) button0.getScene().lookup("#" + button);
        lookup.setText(state == NaughtsCrosses.CROSSES ? "X" : "0");
    }

    @Override
    public void cleanButtons() {
        setText("");
        var style ="";
        button0.setStyle(style);
        changeButtonStyle(style,0,1,9 );
    }

}
