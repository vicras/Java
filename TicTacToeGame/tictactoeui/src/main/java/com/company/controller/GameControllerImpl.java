package com.company.controller;

import com.company.viewcontroller.ViewInterface;
import com.company.engine.field.FieldState;
import com.company.engine.field.NaughtsCrosses;
import com.company.engine.move.Move;
import com.company.engine.move.MoveImpl;
import com.company.engine.state.GameStatus;
import com.company.exception.PlayException;
import com.company.exception.PlayersNotFoundException;
import com.company.game.TicTacToe;
import com.company.game.TicTacToeObserver;
import com.company.leaderboard.GameRecord;
import com.company.leaderboard.RecordImpl;
import com.company.player.Player;
import com.company.player.PlayerImpl;

import java.time.Duration;
import java.time.LocalDateTime;

public class GameControllerImpl implements GameController, TicTacToeObserver {

    TicTacToe ticTacToe;
    ViewInterface view;

    Player player1;
    Player player2;
    private GameStatus current = GameStatus.GAME_END;


    public GameControllerImpl() {
    }

    @Override
    public void move(String buttonId) {
        Move move = parseMove(buttonId);
        Player player = current == GameStatus.PLAYER_1_MOVE ? player1 : player2;
        try {
            view.updateButton(buttonId, current == GameStatus.PLAYER_1_MOVE ? NaughtsCrosses.CROSSES : NaughtsCrosses.NAUGHTS);
            ticTacToe.makeMove(move, player);
        } catch (PlayersNotFoundException e) {
            view.setPlayersAction();
        }
    }

    @Override
    public void setPlayerNames(String player1, String player2) {
        this.player1 = new PlayerImpl(player1);
        this.player2 = new PlayerImpl(player2);
        try {
            ticTacToe.setPlayers(this.player1, this.player2);
        } catch (PlayException e) {

        }
    }

    @Override
    public void newGame() {
        try {
            ticTacToe.startGame();
            view.setDisable(false);
            view.cleanButtons();
        } catch (PlayersNotFoundException e) {
            view.setPlayersAction();
        }
    }

    @Override
    public void init(TicTacToe ticTacToe, ViewInterface view) {
        this.ticTacToe = ticTacToe;
        this.view = view;

        ticTacToe.addListeners(this);
        ticTacToe.addListeners(view);

    }

    @Override
    public String getGameResult() {
        if (current == GameStatus.GAME_END) {

            String ans;
            switch (ticTacToe.getGameResult()
                    .orElse(nullRecord())
                    .getGameResult()) {
                case NAUGHTS_WIN -> ans = "Player 2 is winner!!!";
                case CROSSES_WIN -> ans = "Player 1 is winner!!!";
                default -> ans = "Draw!!!";
            }
            return ans;

        }
        return "Game in process";
    }

    private GameRecord nullRecord() {
        return new RecordImpl(null, null, null, Duration.ZERO, LocalDateTime.of(0, 1, 1, 0, 0), FieldState.IN_THE_PROCESS);
    }

    private Move parseMove(String string) {
        int id = Integer.parseInt(String.valueOf(string.toCharArray()[6]));
        return new MoveImpl(id / 3, id % 3);

    }


    @Override
    public void stateChanged(GameStatus gameStatus) {
        current = gameStatus;
    }
}
