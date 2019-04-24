/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.joda.time.LocalDate;

/**
 * Base class for different transaction types
 */
public abstract class TransactionExport {
    private String accountId;
    private String folioId;
    private BigDecimal amount;
    private String sourceId;
    private String itemId;
    private String reason;
    private String reference;
    private Boolean ignoreRules = true;
    private String terminalId;
    private LocalDate postingDate;

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
}
