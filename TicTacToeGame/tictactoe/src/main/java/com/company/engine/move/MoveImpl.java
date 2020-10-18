package com.company.engine.move;

public class MoveImpl implements Move {

    private final int i;
    private final int j;

    public MoveImpl(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Move getEmpty() {
        return new MoveImpl(0,0);
    }

    @Override
    public int getI() {
        return i;
    }

    @Override
    public int getJ() {
        return j;
    }
}
