/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account;

public class AccountUpdateResponse {
    private String jobId;

    public AccountUpdateResponse() {
    }

    public AccountUpdateResponse(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
