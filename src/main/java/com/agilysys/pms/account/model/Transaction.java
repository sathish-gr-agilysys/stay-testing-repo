/**
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
 * Base class for different transaction types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Transaction {
    @JsonProperty(required = true)
    protected String accountId;
    @JsonProperty(required = true)
    protected BigDecimal amount;
    protected String callType;
    protected String folioId;
    protected BigDecimal freeAllowanceAmount = BigDecimal.ZERO;
    protected Boolean ignoreRules = true;
    @JsonProperty(required = true)
    protected String itemId;
    protected String parentId;
    protected LocalDate postingDate;
    protected LocalDate displayDate;
    @MinValueRestriction(1)
    protected int quantity = 1;
    @MaxLengthRestriction(250)
    protected String reason;
    protected String reference;
    protected String sourceId;
    protected String terminalId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public Boolean getIgnoreRules() {
        return (ignoreRules != null ? ignoreRules : false);
    }

    public void setIgnoreRules(Boolean ignoreRules) {
        this.ignoreRules = ignoreRules;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getCallType() { return callType; }

    public void setCallType(String callType) { this.callType = callType; }

    public BigDecimal getFreeAllowanceAmount() { return freeAllowanceAmount; }

    public void setFreeAllowanceAmount(BigDecimal freeAllowanceAmount) { this.freeAllowanceAmount = freeAllowanceAmount; }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountId).append(amount).append(folioId).append(ignoreRules).append(itemId)
              .append(postingDate).append(displayDate).append(reason).append(reference).append(sourceId)
              .append(terminalId).toHashCode();
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

        return new EqualsBuilder().append(accountId, other.accountId).append(amount, other.amount)
              .append(folioId, other.folioId).append(ignoreRules, other.ignoreRules).append(itemId, other.itemId)
              .append(postingDate, other.postingDate).append(reason, other.reason).append(reference, other.reference)
              .append(sourceId, other.sourceId).append(terminalId, other.terminalId)
              .append(displayDate, other.displayDate).isEquals();
    }
}
