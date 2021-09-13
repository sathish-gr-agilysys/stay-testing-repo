/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.integration;

import com.agilysys.platform.common.rguest.exception.ErrorCode;

public class Error {
    private ErrorCode type;
    private String message;

    public ErrorCode getType() {
        return type;
    }

    public void setType(ErrorCode type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error() {}

    public Error(ErrorCode type, String message) {
        this.type = type;
        this.message = message;
    }
}