/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.Set;

import org.joda.time.LocalDate;

public class TransactionReportRequest {
    private Set<String> accountIds;
    private LocalDate startDate;
    private LocalDate endDate;

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
