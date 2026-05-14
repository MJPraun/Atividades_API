package org.serratec.aula03.exception;

import java.io.Serial;

public class EnumValidationException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public EnumValidationException(String message) {
        super(message);
    }
}