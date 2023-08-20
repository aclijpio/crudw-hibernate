package ru.pio.aclij.exceptions;

public class FailedResolveAddressException extends RuntimeException{
    public FailedResolveAddressException(String message) {
        super(message);
    }

    public FailedResolveAddressException(String message, Throwable cause) {
        super(message, cause);
    }
}
