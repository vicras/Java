package com.company.engine.state;

import com.company.engine.Engine;
import com.company.engine.move.Move;
import com.company.engine.field.FieldInterface;
import com.company.engine.field.FieldState;
import com.company.engine.field.NaughtsCrosses;

public class Player1MoveState implements GameState {

    Engine engine;
    FieldInterface field;

    public Player1MoveState(Engine engine, FieldInterface field) {
        this.engine = engine;
        this.field = field;
    }

    @Override
    public void move(Move move) {
        field.setValue(move, NaughtsCrosses.CROSSES);
        if (field.checkField() == FieldState.IN_THE_PROCESS) {
            engine.setCurrent(engine.getPlayer2Move());
        } else {
            engine.setWinnerTeam(field.getCurrentState());
            endGame();
        }
        engine.notifyObservers();
    }

    @Override
    public void endGame() {
        engine.getGameDuration().endGame();
        engine.setCurrent(engine.getEndGame());

    }

    @Override
    public void startGame() {

    }

    @Override
    public GameStatus getStatus() {
        return GameStatus.PLAYER_1_MOVE;
    }
}
