/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class ReverseRedemptionError {
    private String errorCode;
    private String description;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReverseRedemptionError() {}

    public ReverseRedemptionError(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
