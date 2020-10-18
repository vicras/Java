package com.company.controller;

import com.company.viewcontroller.ViewInterface;
import com.company.game.TicTacToe;

public interface GameController {
    void move(String buttonId);
    void setPlayerNames(String player1, String player2);
    void newGame();
    void init(TicTacToe ticTacToe, ViewInterface view);
    String getGameResult();
}
