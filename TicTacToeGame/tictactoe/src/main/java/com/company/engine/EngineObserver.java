package com.company.engine;

import com.company.engine.state.GameStatus;

public interface EngineObserver {
    void stateChanged(GameStatus status);
}
