/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.integration;

import static com.agilysys.pms.common.exceptions.ExceptionFactory.systemException;

import com.agilysys.platform.common.rguest.exception.RGuestException;
import com.agilysys.pms.common.exceptions.system.SystemContextKey;
import com.agilysys.pms.common.exceptions.system.SystemErrorCode;

public abstract class Result {

    private Error error;

    private int status;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void applyError(Exception exception) {
        if (exception instanceof RGuestException) {
            applyError((RGuestException) exception);
        } else {
            applyError(systemException(SystemErrorCode.SERVER_ERROR).put(SystemContextKey.MESSAGE, exception.toString())
                  .build());
        }
    }

    public void applyError(RGuestException exception) {
        error = new Error(exception.getCode(), exception.getInternalMessage());
        this.status = exception.getCode().httpStatus();
    }

    public void applyError(String message) {
        applyError(systemException(SystemErrorCode.SERVER_ERROR).put(SystemContextKey.MESSAGE, message)
              .build());
    }
}
