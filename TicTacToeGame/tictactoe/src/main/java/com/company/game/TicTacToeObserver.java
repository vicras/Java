package com.company.game;

import com.company.engine.state.GameStatus;

public interface TicTacToeObserver {
    void stateChanged(GameStatus status);
}
