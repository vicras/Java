package com.company.viewcontroller;

import com.company.engine.field.NaughtsCrosses;
import com.company.game.TicTacToeObserver;

public interface ViewInterface extends TicTacToeObserver {
    void setPlayersAction();
    void updateButton(String button, NaughtsCrosses state);
    void setDisable(boolean isDisable);
    void cleanButtons();
}
