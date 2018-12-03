package com.codecool.exception;

import com.codecool.common.ErrorCode;


public class TipperException extends Exception {

    private static final long serialVersionUID = 1377797926L;

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TipperException() { super(); }
    public TipperException(String message) { super(message); }
    public TipperException(String message, Throwable cause) { super(message, cause); }
    public TipperException(Throwable cause) { super(cause); }

    public TipperException(ErrorCode errorCode) {
        setErrorCode(errorCode);
    }

    public TipperException(ErrorCode errorCode, String message) {
        super(message);
        setErrorCode(errorCode);
    }

}
