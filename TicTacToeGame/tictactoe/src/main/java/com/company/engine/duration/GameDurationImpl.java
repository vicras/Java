package com.company.engine.duration;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class GameDurationImpl implements GameDuration {

    private Instant start;
    private Instant pauseStart;
    private Instant end;
    private Instant pauseEnd;
    private Duration pauseTime;
    private boolean inPause = false;

    public GameDurationImpl() {
    }

    private void reset() {
        start = null;
        end = null;
        pauseEnd = null;
        pauseStart = null;
        inPause = false;
        pauseTime = Duration.ofSeconds(0);
    }

    @Override
    public void startGame() {
        reset();
        start = Instant.now();
    }

    @Override
    public void endGame() {
        resume();
        end = Instant.now();
    }

    @Override
    public void pause() {
        inPause = true;
        pauseStart = Instant.now();
    }

    @Override
    public void resume() {
        if (inPause) {
            pauseEnd = Instant.now();
            pauseTime = pauseTime.plus(Duration.between(pauseStart, pauseEnd));
            inPause = false;
        }
    }

    @Override
    public Optional<Duration> getDuration() {
        Instant now = Instant.now();
        if (end != null && start != null)
            return Optional.ofNullable(Duration.between(start, end).minus(pauseTime));
        if (end == null && start != null && inPause)
            return Optional.ofNullable(Duration.between(start, now).minus(pauseTime).minus(Duration.between(pauseStart, now)));
        if (end == null && start != null && !inPause)
            return Optional.ofNullable(Duration.between(start, now).minus(pauseTime).minus(Duration.between(pauseStart, now)));

        return Optional.empty();
    }

}
