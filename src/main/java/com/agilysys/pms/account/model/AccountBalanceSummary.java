package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

public class AccountBalanceSummary {
    private String accountId;
    private BigDecimal accountBalance;
    private Map<String, BigDecimal> folioBalances;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Map<String, BigDecimal> getFolioBalances() {
        return folioBalances;
    }

    public void setFolioBalances(Map<String, BigDecimal> folioBalances) {
        this.folioBalances = folioBalances;
    }
}
