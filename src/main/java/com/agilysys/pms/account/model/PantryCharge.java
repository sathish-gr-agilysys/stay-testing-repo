/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PantryCharge {

    @JsonProperty(required = true)
    private String accountId;

    @JsonProperty(required = true)
    private String folioId;

    private Boolean ignoreRules;
    private Payment payment;

    @MaxLengthRestriction(250)
    private String reason;
    private String reference;
    private String terminalId;
    private BigDecimal amount;
    private String name;

    @JsonProperty(required = true)
    private List<PantryItemDetails> pantryItems;

    public PantryCharge() {}

    public PantryCharge(Payment payment, List<PantryItemDetails> pantryItemsList) {
        this.payment = payment;
        this.pantryItems = pantryItemsList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<PantryItemDetails> getPantryItemsList() {
        return pantryItems;
    }

    public void setPantryItemsList(List<PantryItemDetails> pantryItems) {
        this.pantryItems = pantryItems;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Charge toCharge(String itemId, BigDecimal amount) {
        Charge pantryCharge = new Charge();
        pantryCharge.setAccountId(getAccountId());
        pantryCharge.setFolioId(getFolioId());
        pantryCharge.setIgnoreRules(getIgnoreRules());
        pantryCharge.setReason(getReason());
        pantryCharge.setReference(getReference());
        pantryCharge.setTerminalId(getTerminalId());
        pantryCharge.setPantryItem(true);
        pantryCharge.setItemId(itemId);
        pantryCharge.setAmount(amount);

        return pantryCharge;
    }
}
