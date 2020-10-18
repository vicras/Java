package com.company.engine.duration;

import java.time.Duration;
import java.util.Optional;

public interface GameDuration {
    void startGame();
    void endGame();
    void pause();
    void resume();
    Optional<Duration> getDuration();
}
