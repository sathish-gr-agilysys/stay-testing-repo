package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountsReceivableSettings {
    public enum DefaultRoutingRule {
        ALL_CHARGES,
        NO_CHARGES,
        ROOM_AND_TAX
    }

    @JsonProperty(required = true)
    private BigDecimal creditLimit;
    @JsonProperty(required = true)
    private int defaultTerms;
    private boolean emailPreferred;
    private DefaultRoutingRule defaultRoutingRule;
    private String accountNumber;

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getDefaultTerms() {
        return defaultTerms;
    }

    public void setDefaultTerms(int defaultTerms) {
        this.defaultTerms = defaultTerms;
    }

    public boolean isEmailPreferred() {
        return emailPreferred;
    }

    public void setEmailPreferred(boolean emailPreferred) {
        this.emailPreferred = emailPreferred;
    }

    public DefaultRoutingRule getDefaultRoutingRule() {
        return defaultRoutingRule;
    }

    public void setDefaultRoutingRule(DefaultRoutingRule defaultRoutingRule) {
        this.defaultRoutingRule = defaultRoutingRule;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
