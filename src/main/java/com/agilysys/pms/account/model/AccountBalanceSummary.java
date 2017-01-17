package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

public class AccountBalanceSummary {
    private String accountId;
    private BigDecimal accountBalance;
    private BigDecimal accountTaxBalance;
    private Map<String, BigDecimal> folioBalances;
    private Map<String, BigDecimal> folioTaxBalances;

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

    public BigDecimal getAccountTaxBalance() {
        return accountTaxBalance;
    }

    public void setAccountTaxBalance(BigDecimal accountTaxBalance) {
        this.accountTaxBalance = accountTaxBalance;
    }

    public Map<String, BigDecimal> getFolioBalances() {
        return folioBalances;
    }

    public void setFolioBalances(Map<String, BigDecimal> folioBalances) {
        this.folioBalances = folioBalances;
    }

    public Map<String, BigDecimal> getFolioTaxBalances() {
        return folioTaxBalances;
    }

    public void setFolioTaxBalances(Map<String, BigDecimal> folioTaxBalances) {
        this.folioTaxBalances = folioTaxBalances;
    }
}
