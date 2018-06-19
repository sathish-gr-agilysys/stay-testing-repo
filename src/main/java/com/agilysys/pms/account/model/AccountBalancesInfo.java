package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class AccountBalancesInfo {
    private Map<String, AccountBalanceDetail> accountBalances = Collections.emptyMap();

    private BigDecimal grandTotal = BigDecimal.ZERO;
    private BigDecimal grandTaxTotal = BigDecimal.ZERO;

    public Map<String, AccountBalanceDetail> getAccountBalances() {
        return accountBalances;
    }

    public void setAccountBalances(Map<String, AccountBalanceDetail> accountBalances) {
        this.accountBalances = accountBalances;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public BigDecimal getGrandTaxTotal() {
        return grandTaxTotal;
    }

    public void setGrandTaxTotal(BigDecimal grandTaxTotal) {
        this.grandTaxTotal = grandTaxTotal;
    }
}
