/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class CompleteReverseRedemptionRequestAyncJobId {
    private String asyncJobId;

    public CompleteReverseRedemptionRequestAyncJobId() {
    }

    public CompleteReverseRedemptionRequestAyncJobId(String asyncJobId) {
        this.asyncJobId = asyncJobId;
    }

    public String getAsyncJobId() {
        return asyncJobId;
    }

    public void setAsyncJobId(String asyncJobId) {
        this.asyncJobId = asyncJobId;
    }
}
