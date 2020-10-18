package com.company.player;

public class PlayerImpl implements Player {
    private String name;

    public PlayerImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
