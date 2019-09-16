/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class CompTransaction {
    private String authorizerId;
    private String departmentId;
    private String accountId;
    private List<CompRedeemRequest> compRedeemRequests;

    public String getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(String authorizerId) {
        this.authorizerId = authorizerId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<CompRedeemRequest> getCompRedeemRequests() {
        return compRedeemRequests;
    }

    public void setCompRedeemRequests(List<CompRedeemRequest> compRedeemRequests) {
        this.compRedeemRequests = compRedeemRequests;
    }
}
