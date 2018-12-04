package com.codecool.common;

public enum ErrorCode {

    USERNAME_ALREADY_EXISTS ("users_username_unique"),
    EMAIL_ALREADY_EXIST ("users_email_unique"),
    WRONG_USERNAME_OR_PASSWORD("wrong_username_or_password");

    private final String constraint;

    public String getConstraint() {
        return constraint;
    }

    private ErrorCode(String constraint) {
        this.constraint = constraint;
    }
}
