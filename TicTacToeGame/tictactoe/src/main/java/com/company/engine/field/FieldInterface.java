package com.company.engine.field;

import com.company.engine.field.checker.WinPosition;
import com.company.engine.move.Move;

public interface FieldInterface {

    void cleanField();
    NaughtsCrosses getValue(int i, int j);
    void setValue(Move move, NaughtsCrosses state);
    FieldState checkField();
    int getFieldSize();
    FieldState getCurrentState();
    WinPosition getWinPosition();

}
