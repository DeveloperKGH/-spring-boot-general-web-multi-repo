package com.web.multi.global.error.exception;

public class NotSupportedCodeException extends RuntimeException {

    public NotSupportedCodeException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}