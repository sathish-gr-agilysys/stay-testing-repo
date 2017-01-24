/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Set;

public class AccountBalancesRequest {
    private Set<String> accountIds;

    private Set<String> accountTypes;

    private Set<String> accountStatuses;

    private BigDecimal minBalance;

    private BigDecimal maxBalance;

    private Boolean includeZeroBalance;

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Set<String> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(Set<String> accountTypes) {
        this.accountTypes = accountTypes;
    }

    public Set<String> getAccountStatuses() {
        return accountStatuses;
    }

    public void setAccountStatuses(Set<String> accountStatuses) {
        this.accountStatuses = accountStatuses;
    }

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }

    public BigDecimal getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(BigDecimal maxBalance) {
        this.maxBalance = maxBalance;
    }

    public Boolean getIncludeZeroBalance() {
        return includeZeroBalance;
    }

    public void setIncludeZeroBalance(Boolean includeZeroBalance) {
        this.includeZeroBalance = includeZeroBalance;
    }
}
