/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class AccountAttributes {
    private String accountContactId;
    private PreferredCommunication preferredCommunication;
    private AccountStatus status;
    private BigDecimal creditLimit;
    private int terms;
    private DefaultRoutingRule routingRule;
    private TenantARTaxExemptSettings taxExemptSettings;

    public AccountAttributes() {
    }

    public AccountAttributes(String accountContactId, PreferredCommunication preferredCommunication,
          AccountStatus status, BigDecimal creditLimit, int terms, DefaultRoutingRule routingRule,
          TenantARTaxExemptSettings taxExemptSettings) {
        this.accountContactId = accountContactId;
        this.preferredCommunication = preferredCommunication;
        this.status = status;
        this.creditLimit = creditLimit;
        this.terms = terms;
        this.routingRule = routingRule;
        this.taxExemptSettings = taxExemptSettings;
    }

    public enum AccountStatus {
        PENDING,
        OPEN,
        CLOSED
    }

    public enum PreferredCommunication {
        Email,
        Print
    }

    public enum DefaultRoutingRule {
        ALL_CHARGES,
        NO_CHARGES,
        ROOM_AND_TAX
    }

    public String getAccountContactId() {
        return accountContactId;
    }

    public void setAccountContactId(String accountContactId) {
        this.accountContactId = accountContactId;
    }

    public PreferredCommunication getPreferredCommunication() {
        return preferredCommunication;
    }

    public void setPreferredCommunication(PreferredCommunication preferredCommunication) {
        this.preferredCommunication = preferredCommunication;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public DefaultRoutingRule getRoutingRule() {
        return routingRule;
    }

    public void setRoutingRule(DefaultRoutingRule routingRule) {
        this.routingRule = routingRule;
    }

    public TenantARTaxExemptSettings getTaxExemptSettings() {
        return taxExemptSettings;
    }

    public void setTaxExemptSettings(TenantARTaxExemptSettings taxExemptSettings) {
        this.taxExemptSettings = taxExemptSettings;
    }
}
