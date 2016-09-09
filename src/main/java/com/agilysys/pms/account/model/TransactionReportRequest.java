/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.Set;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReportRequest {
    private Set<String> accountIds;
    @JsonProperty(required = true)
    private LocalDate propertyDate;

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public LocalDate getPropertyDate() {
        return propertyDate;
    }

    public void setPropertyDate(LocalDate propertyDate) {
        this.propertyDate = propertyDate;
    }
}
