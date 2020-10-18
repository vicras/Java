package com.company.viewcontroller;

import com.company.engine.field.FieldState;
import com.company.leaderboard.GameRecord;
import com.company.leaderboard.Leaderboard;
import com.company.leaderboard.RecordImpl;
import com.company.player.PlayerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class LeaderboardController {

    private TicTacToeController base;

    public static void invoke(Stage primaryStage, TicTacToeController base) {

        Parent root = null;
        URL location = SetPlayersController.class.getResource("../views/leaderboard.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LeaderboardController controller = loader.getController();
        controller.init(base);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Leaderboard");
        newWindow.setScene(new Scene(root, 600, 400));

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);

        // Set position of second window, related to primary window.
        newWindow.setX(primaryStage.getX() + - 50);
        newWindow.setY(primaryStage.getY() + 50);

        newWindow.show();
    }

    @FXML
    private TableView<GameRecord> tableTV;

    @FXML
    private TableColumn<?, ?> playersCol;

    @FXML
    private TableColumn<?, ?> player1Col;

    @FXML
    private TableColumn<?, ?> player2Col;

    @FXML
    private TableColumn<?, ?> winnerCol;

    @FXML
    private TableColumn<?, ?> winTeamCol;

    @FXML
    private TableColumn<?, ?> durationCol;

    @FXML
    private TableColumn<?, ?> gameDateCol;

    void init(TicTacToeController controller){
        base = controller;
        Leaderboard leaderboard = controller.getEngine().getLeaderboard();
        initTable();
        updateTable(leaderboard);

    }

    private void initTable(){
        winnerCol.setCellValueFactory(new PropertyValueFactory<>("winner"));
        player1Col.setCellValueFactory(new PropertyValueFactory<>("player1"));
        player2Col.setCellValueFactory(new PropertyValueFactory<>("player2"));
        winTeamCol.setCellValueFactory(new PropertyValueFactory<>("gameResult"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        gameDateCol.setCellValueFactory(new PropertyValueFactory<>("gameTime"));
    }

    private void updateTable(Leaderboard leaderboard){
        ObservableList<GameRecord> list = getTableValues(leaderboard);
        tableTV.setItems(list);
    }

    private ObservableList<GameRecord> getTableValues(Leaderboard leaderboard){
//        return Stream.generate(this::nullRecord)
//                .limit(20)
//                .collect(Collector.of(
//                        FXCollections::observableArrayList,
//                        ObservableList::add,
//                        (a,b )-> {
//                            a.addAll(b);
//                            return a;
//                        }));
        return leaderboard.getRecords().stream()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
    private GameRecord nullRecord() {
        PlayerImpl ivan = new PlayerImpl("ivan");
        return new RecordImpl(new PlayerImpl("vik"), ivan, ivan, Duration.ZERO, LocalDateTime.of(0, 1, 1, 0, 0), FieldState.IN_THE_PROCESS);
    }

}
