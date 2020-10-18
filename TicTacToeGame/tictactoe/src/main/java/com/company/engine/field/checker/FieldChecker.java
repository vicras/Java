package com.company.engine.field.checker;

import com.company.engine.move.Move;
import com.company.engine.field.FieldState;
import com.company.engine.field.NaughtsCrosses;

public interface FieldChecker {
    FieldState checkField(NaughtsCrosses[][] field, Move move);
    WinPosition getWinPosition(NaughtsCrosses[][] field, Move move);
}
