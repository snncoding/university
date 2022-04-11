package com.snn.university.exception;

import javax.persistence.EntityNotFoundException;
import java.util.Locale;

public class MyEntityNotFoundException extends EntityNotFoundException {
    private static final String MESSAGE_FORMAT = "Could not found given %s id: %d";
    private String message;
    public MyEntityNotFoundException(Integer id, String name) {
        message = String.format(MESSAGE_FORMAT, name, id);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
