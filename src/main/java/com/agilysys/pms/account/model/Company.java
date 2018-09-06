/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class Company {
    private String companyId;

    private List<AccountId> accountIds;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public List<AccountId> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<AccountId> accountIds) {
        this.accountIds = accountIds;
    }
}
