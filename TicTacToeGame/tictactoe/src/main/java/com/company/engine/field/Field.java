package com.company.engine.field;

import com.company.engine.field.checker.FieldChecker;
import com.company.engine.field.checker.WinPosition;
import com.company.engine.move.Move;

import java.util.stream.Stream;

public class Field implements FieldInterface {

    private final int FIELD_SIZE = 3;
    private final FieldChecker checker;
    private NaughtsCrosses[][] field ={
            {NaughtsCrosses.EMPTY,NaughtsCrosses.EMPTY,NaughtsCrosses.CROSSES },
            {NaughtsCrosses.EMPTY,NaughtsCrosses.CROSSES,NaughtsCrosses.EMPTY },
            {NaughtsCrosses.CROSSES,NaughtsCrosses.EMPTY,NaughtsCrosses.EMPTY }
    };
    private FieldState current;
    private WinPosition winPosition= new WinPosition();


    public Field(FieldChecker checker) {
        this.checker = checker;
        cleanField();
    }

    @Override
    public void cleanField() {
        field = Stream.generate(() -> NaughtsCrosses.EMPTY)
                .limit(FIELD_SIZE)
                .map(column -> Stream.generate(() -> NaughtsCrosses.EMPTY)
                        .limit(FIELD_SIZE)
                        .toArray(NaughtsCrosses[]::new))
                .toArray(NaughtsCrosses[][]::new);
        current = FieldState.IN_THE_PROCESS;
    }

    @Override
    public NaughtsCrosses getValue(int i, int j) {
        return field[i][j];
    }

    @Override
    public void setValue(Move move, NaughtsCrosses state) {
        field[move.getI()][move.getJ()] = state;
        current = checker.checkField(field,move);
        winPosition =checker.getWinPosition(field,move);
    }

    @Override
    public FieldState checkField() {
        return current;
    }

    @Override
    public int getFieldSize() {
        return FIELD_SIZE;
    }

    @Override
    public FieldState getCurrentState() {
        return current;
    }

    @Override
    public WinPosition getWinPosition() {
        return winPosition;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for(var i : field){
            for(var j : i){
                ans.append(j).append(" ");
            }
            ans.append("\n");
        }
        return ans.toString();
    }


}
