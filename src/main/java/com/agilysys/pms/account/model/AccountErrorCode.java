package com.agilysys.pms.account.model;

public enum AccountErrorCode {
    // Arbitrarily picking 4000 for the starting point for AccountService error codes
    GENERAL_ACCOUNT_ERROR(4000),
    CREDIT_LIMIT_EXCEEDED(4001),
    DATABASE_ERROR(4002),
    NO_PROPERTY_DATE(4003);

    private int code;

    private AccountErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
