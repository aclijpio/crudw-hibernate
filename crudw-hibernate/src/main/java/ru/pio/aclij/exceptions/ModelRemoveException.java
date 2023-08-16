package ru.pio.aclij.exceptions;

public class ModelRemoveException extends RuntimeException{

    public ModelRemoveException(String message) {
        super(message);
    }

    public ModelRemoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
