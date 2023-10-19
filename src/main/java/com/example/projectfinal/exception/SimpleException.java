package com.example.projectfinal.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleException extends RuntimeException{

    private ErrorCode errorCode;
    private String message;

    public SimpleException(ErrorCode errorCode, String format) {
        this.errorCode = errorCode;
        this.message = null;
    }

    @Override
    public String getMessage() {
        if (message == null) {
            return errorCode.getMessage();
        } else {
            return String.format("%s. %s", errorCode.getMessage(), message);
        }
    }
}
