/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class MultipleAccountPaymentRequestAsyncJobId {
    private String asyncJobId;

    public MultipleAccountPaymentRequestAsyncJobId(){}

    public MultipleAccountPaymentRequestAsyncJobId(String asyncJobId){
        this.asyncJobId = asyncJobId;
    }

    public String getAsyncJobId() {
        return asyncJobId;
    }

    public void setAsyncJobId(String asyncJobId) {
        this.asyncJobId = asyncJobId;
    }
}
