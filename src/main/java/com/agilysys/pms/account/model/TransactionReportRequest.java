/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReportRequest {
    @JsonProperty(required = true)
    private Set<String> accountIds;

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }
}
