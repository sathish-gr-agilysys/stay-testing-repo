package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

public class AccountBalanceDetail extends AccountSummary {
    private BigDecimal accountBalance;
    private BigDecimal accountTaxBalance;

    private Map<String, FolioBalance> folioBalances;

    private boolean postingRule;

    /**
     * Get accountBalance
     *
     * @return balance of the Account
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * Set accountBalance
     *
     * @param accountBalance
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAccountTaxBalance() {
        return accountTaxBalance;
    }

    public void setAccountTaxBalance(BigDecimal accountTaxBalance) {
        this.accountTaxBalance = accountTaxBalance;
    }

    /**
     * Get folioBalances
     *
     * @return Map of folioId to folioBalances
     */
    public Map<String, FolioBalance> getFolioBalances() {
        return folioBalances;
    }

    /**
     * Set folioBalances
     *
     * @param folioBalances folioBalances to set
     */
    public void setFolioBalances(Map<String, FolioBalance> folioBalances) {
        this.folioBalances = folioBalances;
    }

    public boolean isPostingRule() {
        return postingRule;
    }

    public void setPostingRule(boolean postingRule) {
        this.postingRule = postingRule;
    }
}
