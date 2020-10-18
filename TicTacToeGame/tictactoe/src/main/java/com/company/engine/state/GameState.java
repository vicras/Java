package com.company.engine.state;

import com.company.engine.move.Move;

public interface GameState {

    void move(Move move);
    void endGame();
    void startGame();
    GameStatus getStatus();
}
