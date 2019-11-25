/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PostCancellationDetail {

    private boolean success;

    private String errorMessage;

    private String errorCode;

    public PostCancellationDetail() {
    }

    public PostCancellationDetail(boolean success) {
        this.success = success;
    }

    public PostCancellationDetail(boolean success, String errorMessage, String errorCode) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
