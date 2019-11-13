package com.prateek.learning.employees.utils;

import lombok.Getter;

@Getter
public enum ErrorConstant {
    DEFAULT_ERROR_CONSTANT("EMPLOYEE_RECORD_ERR_0000", "default_err_messages"),
    FIRST_NAME_MANDATORY("EMPLOYEE_RECORD_ERR_0001");

    private String errorCode;
    private String messageCode;

    ErrorConstant(String errorCode) {
        this.errorCode = errorCode;
        this.messageCode = name().toLowerCase();
    }

    ErrorConstant(String errorCode, String messageCode) {
        this.errorCode = errorCode;
        this.messageCode = messageCode;
    }

    public static ErrorConstant getInstance(String errorConstantAsString) {
        for (ErrorConstant errorConstant : values()) {
            if (errorConstant.name().equalsIgnoreCase(errorConstantAsString) || errorConstant.messageCode.equalsIgnoreCase(errorConstantAsString)) {
                return errorConstant;
            }
        }
        throw new IllegalArgumentException(String.format("Please define ErrorConstant with proper error code:- %s in ErrorConstant.java and corresponding error message in messages.properties file", errorConstantAsString));
    }
}
