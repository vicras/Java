package com.company.engine;

import com.company.engine.duration.GameDuration;
import com.company.engine.field.FieldInterface;
import com.company.engine.field.FieldState;
import com.company.engine.field.checker.WinPosition;
import com.company.engine.move.Move;
import com.company.engine.state.GameState;
import com.company.player.Player;

import java.util.Optional;

public interface EngineInterface {
    void startGame(Player player1, Player player2);
//    void pause();
//    void resume();
    void newMove(Move move);
    GameDuration getGameDuration();
    Optional<Player> getPlayer1();
    Optional<Player> getPlayer2();
    FieldState getWinnerTeam();
    FieldInterface getField();

    GameState getCurrentState();
    WinPosition getWinPosition();

    void addObserver(EngineObserver observer);
    boolean removeObserver(EngineObserver observer);

}
