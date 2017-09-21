package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.platform.common.json.schema.PatternRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountsReceivableSettings {
    private static final String ACCOUNT_NUMBER_VALIDATION_REGEX = "^[a-zA-Z0-9-]+$";
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
    @Deprecated
    @MinLengthRestriction(4)
    @MaxLengthRestriction(12)
    @PatternRestriction(ACCOUNT_NUMBER_VALIDATION_REGEX)
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
