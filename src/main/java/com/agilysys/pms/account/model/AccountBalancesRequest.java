/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class AccountBalancesRequest {
    private Set<String> accountIds;
    private Set<String> accountTypes;
    private Set<String> accountStatuses;
    private Set<String> paymentMethodIds;
    private BigDecimal minBalance;
    private BigDecimal maxBalance;
    private IgnoreZeroBalance ignoreZeroBalance;

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

    public Set<String> getPaymentMethodIds() {
        return paymentMethodIds;
    }

    public void setPaymentMethodIds(Set<String> paymentMethodIds) {
        this.paymentMethodIds = paymentMethodIds;
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

    public IgnoreZeroBalance getIgnoreZeroBalance() {
        return ignoreZeroBalance;
    }

    public void setIgnoreZeroBalance(IgnoreZeroBalance ignoreZeroBalance) {
        this.ignoreZeroBalance = ignoreZeroBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AccountBalancesRequest that = (AccountBalancesRequest) o;
        return Objects.equals(accountIds, that.accountIds) && Objects.equals(accountTypes, that.accountTypes) &&
              Objects.equals(accountStatuses, that.accountStatuses) &&
              Objects.equals(paymentMethodIds, that.paymentMethodIds) && Objects.equals(minBalance, that.minBalance) &&
              Objects.equals(maxBalance, that.maxBalance) && Objects.equals(ignoreZeroBalance, that.ignoreZeroBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIds, accountTypes, accountStatuses, paymentMethodIds, minBalance, maxBalance,
              ignoreZeroBalance);
    }

    public static class IgnoreZeroBalance {
        private Boolean excludeCompanyAccounts;
        private Boolean excludeHouseAccounts;

        public Boolean getExcludeCompanyAccounts() {
            return excludeCompanyAccounts;
        }

        public void setExcludeCompanyAccounts(Boolean excludeCompanyAccounts) {
            this.excludeCompanyAccounts = excludeCompanyAccounts;
        }

        public Boolean getExcludeHouseAccounts() {
            return excludeHouseAccounts;
        }

        public void setExcludeHouseAccounts(Boolean excludeHouseAccounts) {
            this.excludeHouseAccounts = excludeHouseAccounts;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            IgnoreZeroBalance that = (IgnoreZeroBalance) o;
            return Objects.equals(excludeCompanyAccounts, that.excludeCompanyAccounts) &&
                  Objects.equals(excludeHouseAccounts, that.excludeHouseAccounts);
        }

        @Override
        public int hashCode() {
            return Objects.hash(excludeCompanyAccounts, excludeHouseAccounts);
        }
    }
}
