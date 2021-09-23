package com.vicras.users.exceptoins;

import static java.lang.String.format;

/**
 * @author viktar hraskou
 */
public class EntityExistException extends RuntimeException {
    public EntityExistException(Object object) {
        super(format("Entity {%s} already exist", object));
    }
}
