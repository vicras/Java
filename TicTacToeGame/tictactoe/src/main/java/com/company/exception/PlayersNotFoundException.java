package com.company.exception;

public class PlayersNotFoundException extends Exception {
    public PlayersNotFoundException(String message) {
        super(message);
    }

    public PlayersNotFoundException() {
        super();
    }
}
