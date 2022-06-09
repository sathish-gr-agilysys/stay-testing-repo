package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Set;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.platform.common.json.schema.PatternRestriction;
import com.agilysys.pms.common.model.ThirdPartyConfirmation;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.agilysys.common.utils.Utils.ALPHANUMERIC_HYPHEN_VALIDATION_REGEX;

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
    @MinLengthRestriction(4)
    @MaxLengthRestriction(12)
    @PatternRestriction(ALPHANUMERIC_HYPHEN_VALIDATION_REGEX)
    private String accountNumber;

    private boolean requiredReferenceNumber;

    private Boolean showSelectedThirdPartyConfirmation;
    private Set<ThirdPartyConfirmation> selectedThirdPartyConfirmations;

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

    public void setRequiredReferenceNumber(Boolean requiredReferenceNumber) {
        this.requiredReferenceNumber = requiredReferenceNumber;
    }

    public Boolean isShowSelectedThirdPartyConfirmation() {
        return showSelectedThirdPartyConfirmation;
    }

    public void setShowSelectedThirdPartyConfirmation(boolean showSelectedThirdPartyConfirmation) {
        this.showSelectedThirdPartyConfirmation = showSelectedThirdPartyConfirmation;
    }

    public Set<ThirdPartyConfirmation> getSelectedThirdPartyConfirmations() {
        return selectedThirdPartyConfirmations;
    }

    public void setSelectedThirdPartyConfirmations(Set<ThirdPartyConfirmation> selectedThirdPartyConfirmations) {
        this.selectedThirdPartyConfirmations = selectedThirdPartyConfirmations;
    }
}
