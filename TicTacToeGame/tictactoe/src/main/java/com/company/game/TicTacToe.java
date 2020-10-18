package com.company.game;

import com.company.exception.PlayException;
import com.company.exception.PlayersNotFoundException;
import com.company.leaderboard.GameRecord;
import com.company.leaderboard.Leaderboard;
import com.company.engine.field.FieldInterface;
import com.company.engine.field.checker.WinPosition;
import com.company.engine.move.Move;
import com.company.player.Player;

import java.util.Optional;

public interface TicTacToe {
    void startGame() throws PlayersNotFoundException;
    void makeMove(Move move, Player player) throws PlayersNotFoundException;
    void setPlayers(Player player1, Player player2) throws PlayException;
    FieldInterface getField();
    Leaderboard getLeaderboard();
    Optional<Player> getPlayer1();
    Optional<Player> getPlayer2();
    Optional<GameRecord> getGameResult();
    WinPosition getWinPosition();

    void addListeners(TicTacToeObserver observer);
    void removeListeners(TicTacToeObserver observer);
}
