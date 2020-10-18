package com.company.engine.state;

import com.company.engine.Engine;
import com.company.engine.move.Move;

import java.util.Random;

public class EndState implements GameState {

    Engine engine;

    public EndState(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void move(Move move) {

    }

    @Override
    public void endGame() {

    }

    @Override
    public void startGame() {
        if (new Random().nextBoolean()) {
            engine.setCurrent(engine.getPlayer1Move());
        } else {
            engine.setCurrent(engine.getPlayer2Move());
        }
        engine.notifyObservers();
    }

    @Override
    public GameStatus getStatus() {
        return GameStatus.GAME_END;
    }
}
