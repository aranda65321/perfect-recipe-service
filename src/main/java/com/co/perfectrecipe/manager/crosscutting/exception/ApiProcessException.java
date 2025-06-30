package com.co.perfectrecipe.manager.crosscutting.exception;

import com.co.perfectrecipe.manager.crosscutting.domain.enums.TypeError;

public class ApiProcessException extends Exception {

    private TypeError typeError;

    public ApiProcessException(Throwable cause, TypeError typeError) {
        super(typeError.getDescription(), cause);
    }

    public ApiProcessException(TypeError typeError) {
        super(typeError.getDescription());
    }

    public ApiProcessException(String message) {
        super(message);
    }

    public ApiProcessException(Throwable cause) {
        super(cause);
    }

    public TypeError getTypeError() {
        return typeError;
    }
}
