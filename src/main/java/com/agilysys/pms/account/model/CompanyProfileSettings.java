/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class CompanyProfileSettings {
    private AccountSettings account;
    private String userId;
    private RatePlan ratePlan;

    public CompanyProfileSettings() {
    }

    public CompanyProfileSettings(AccountSettings account, String userId, RatePlan ratePlan) {
        this.account = account;
        this.userId = userId;
        this.ratePlan = ratePlan;
    }

    public AccountSettings getAccount() {
        return account;
    }

    public void setAccount(AccountSettings account) {
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan ratePlan) {
        this.ratePlan = ratePlan;
    }
}
