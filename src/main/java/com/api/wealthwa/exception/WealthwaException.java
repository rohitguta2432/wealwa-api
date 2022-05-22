package com.api.wealthwa.exception;

public class WealthwaException extends RuntimeException {

    private static final long serialVersionUID = 2771174581631905388L;

    public WealthwaException() {
    }

    public WealthwaException(String message) {
        super(message);
    }

    public WealthwaException(String message, Throwable cause) {
        super(message, cause);
    }


    public WealthwaException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
