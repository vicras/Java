package com.company.engine;

import com.company.engine.duration.GameDuration;
import com.company.engine.duration.GameDurationImpl;
import com.company.engine.field.Field;
import com.company.engine.field.FieldInterface;
import com.company.engine.field.FieldState;
import com.company.engine.field.checker.FieldChecker;
import com.company.engine.field.checker.FieldCheckerImpl;
import com.company.engine.field.checker.WinPosition;
import com.company.engine.move.Move;
import com.company.engine.state.EndState;
import com.company.engine.state.GameState;
import com.company.engine.state.Player1MoveState;
import com.company.engine.state.Player2MoveState;
import com.company.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Engine implements EngineInterface {

    private GameState current;
    private final GameState player1Move;
    private final GameState player2Move;
    private final GameState endGame;
    private final FieldInterface field;

    private final GameDuration gameDuration;

    private Player player1;
    private Player player2;
    private FieldState winnerTeam = FieldState.IN_THE_PROCESS;

    private final List<EngineObserver> observers;

    public Engine() {
        gameDuration = new GameDurationImpl();
        FieldChecker checker = new FieldCheckerImpl();
        field = new Field(checker);
        observers = new ArrayList<>();

        player1Move = new Player1MoveState(this, field);
        player2Move = new Player2MoveState(this, field);
        endGame = new EndState(this);

        current = endGame;
    }

    public GameState getPlayer1Move() {
        return player1Move;
    }

    public GameState getPlayer2Move() {
        return player2Move;
    }

    public GameState getEndGame() {
        return endGame;
    }

    public Optional<Player> getPlayer1() {
        return Optional.ofNullable(player1);
    }

    public Optional<Player> getPlayer2() {
        return Optional.ofNullable(player2);
    }

    public FieldState getWinnerTeam() {
        return winnerTeam;
    }

    @Override
    public FieldInterface getField() {
        return field;
    }

    public void setCurrent(GameState current) {
        this.current = current;
    }

    public void setWinnerTeam(FieldState winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public void notifyObservers(){
        observers.forEach((i)-> i.stateChanged(current.getStatus()));
    }


    @Override
    public GameDuration getGameDuration() {
        return gameDuration;
    }

    @Override
    public void startGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        winnerTeam = FieldState.IN_THE_PROCESS;
        field.cleanField();
        current.startGame();
        gameDuration.startGame();
    }



    @Override
    public void newMove(Move move) {
        current.move(move);
    }

    @Override
    public GameState getCurrentState() {
        return current;
    }

    @Override
    public WinPosition getWinPosition() {
        return field.getWinPosition();
    }

    @Override
    public void addObserver(EngineObserver observer) {
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(EngineObserver observer) {
        return observers.remove(observer);
    }

}
