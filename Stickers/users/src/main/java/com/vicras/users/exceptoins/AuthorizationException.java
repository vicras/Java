package com.vicras.users.exceptoins;

/**
 * @author viktar hraskou
 */
public class AuthorizationException extends RuntimeException {
    public AuthorizationException() {
        super("Can't authorize user");
    }
}
