package ru.pio.aclij.exceptions;

public class ModelSaveException extends RuntimeException{

    public ModelSaveException(String message) {
        super(message);
    }

    public ModelSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
