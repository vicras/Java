package com.vicras.lib.exceptions;

import static java.lang.String.format;

/**
 * @author viktar hraskou
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> clazz, Object id) {
        super(format("Entity {%s} with id=%s not found", clazz, id));
    }
}
