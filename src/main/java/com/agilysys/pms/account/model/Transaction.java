/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.agilysys.platform.common.json.schema.MinValueRestriction;

/**
 * Base class for different transaction types
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Transaction {
    @JsonProperty(required = true)
    private String accountId;

    private String folioId;

    @JsonProperty(required = true)
    private BigDecimal amount;

    private String sourceId;

    @JsonProperty(required = true)
    private String itemId;

    @MaxLengthRestriction(250)
    private String reason;

    private String reference;
    private Boolean ignoreRules = true;
    private String terminalId;
    private LocalDate postingDate;
    private String parentId;

    @MinValueRestriction(1)
    private int quantity = 0;

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId ID of account to charge
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the folioId
     */
    public String getFolioId() {
        return folioId;
    }

    /**
     * @param folioId Optionally specify a folioId to target.  Must match a folio for the accountId specified.
     *                Otherwise default folio will be used
     */
    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount Amount charged for 1 of the item
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * @return the sourceId
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * @param sourceId ID of Charge source
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId ID of transaction item being charged
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason Optional reason for this Charge
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference Optional reference from POS
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the ignoreRules
     */
    public Boolean getIgnoreRules() {
        return (ignoreRules != null ? ignoreRules : false);
    }

    /**
     * @param ignoreRules true if target account/folio rules must be ignored
     */
    public void setIgnoreRules(Boolean ignoreRules) {
        this.ignoreRules = ignoreRules;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * @return Date for the transaction posting or null if using current property date
     */
    public LocalDate getPostingDate() {
        return postingDate;
    }

    /**
     * Optional - Sets the date to post the transaction to if posting to a previous fiscal day.  Special permissions
     * are required to set this to a value other than the current property date.
     *
     * @param postingDate
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(accountId).append(folioId).append(amount).append(sourceId).append(itemId).append(reason)
              .append(reference).append(ignoreRules).append(terminalId).append(postingDate);
        return hashCodeBuilder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(accountId, other.accountId).append(folioId, other.folioId).append(amount, other.amount)
              .append(sourceId, other.sourceId).append(itemId, other.itemId).append(reason, other.reason)
              .append(reference, other.reference).append(ignoreRules, other.ignoreRules)
              .append(terminalId, other.terminalId).append(postingDate, other.postingDate);
        return equalsBuilder.isEquals();
    }
}
