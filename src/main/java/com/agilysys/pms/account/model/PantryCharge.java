/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PantryCharge {

    @JsonProperty(required = true)
    private String accountId;

    @JsonProperty(required = true)
    private String folioId;

    protected Boolean ignoreRules = true;
    private boolean isPayment;
    private Payment payment;
    private String reason;
    private String reference;
    private String terminalId;
    private List<PantryItemDetails> pantryItemsList;

    public PantryCharge() {
    }

    public PantryCharge(Boolean isPayment, Payment payment, List<PantryItemDetails> pantryItemsList) {
        this.isPayment = isPayment;
        this.payment = payment;
        this.pantryItemsList = pantryItemsList;
    }

    public boolean isPayment() {
        return isPayment;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<PantryItemDetails> getPantryItemsList() {
        return pantryItemsList;
    }

    public void setPantryItemsList(List<PantryItemDetails> pantryItemsList) {
        this.pantryItemsList = pantryItemsList;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public Boolean getIgnoreRules() {
        return ignoreRules;
    }

    public void setIgnoreRules(Boolean ignoreRules) {
        this.ignoreRules = ignoreRules;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
}
