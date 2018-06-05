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
