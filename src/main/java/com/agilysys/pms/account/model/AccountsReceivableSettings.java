package com.agilysys.pms.account.model;

import static com.agilysys.common.utils.Utils.ALPHANUMERIC_HYPHEN_VALIDATION_REGEX;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountsReceivableSettings {
    public enum DefaultRoutingRule {
        ALL_CHARGES,
        NO_CHARGES,
        ROOM_AND_TAX,
        THIRD_PARTY_PAYMENTS
    }

    @JsonProperty(required = true)
    private BigDecimal creditLimit;
    @JsonProperty(required = true)
    private int defaultTerms;
    private boolean emailPreferred;
    private DefaultRoutingRule defaultRoutingRule;
    @Deprecated
    @Min(4)
    @Max(12)
    @Pattern(regexp = ALPHANUMERIC_HYPHEN_VALIDATION_REGEX)
    private String accountNumber;

    private boolean requiredReferenceNumber;

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

    public boolean isRequiredReferenceNumber() {
        return requiredReferenceNumber;
    }

    public void setRequiredReferenceNumber(boolean requiredReferenceNumber) {
        this.requiredReferenceNumber = requiredReferenceNumber;
    }
}
