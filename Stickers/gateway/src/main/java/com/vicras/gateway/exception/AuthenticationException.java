package com.vicras.gateway.exception;

/**
 * @author viktar hraskou
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }
}
