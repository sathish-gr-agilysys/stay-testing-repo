/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Represents an item in a NightAuditReport
 */
public class NightAuditReportItem {
    private String ledgerTransactionId;
    private String mealPeriodId;
    private String transactionItemId;
    private String itemName;
    private BigDecimal amount;
    private NightAuditTransactionType transactionType;
    private String ledger;
    private String sourceId;
    private String sourceLedger;
    private String destinationLedger;
    private LocalDate postingPropertyDate;
    private DateTime postingCalendarDateTime;
    private String accountId;
    private String accountType;
    private String referenceId;
    private String userId;

    public String getLedgerTransactionId() {
        return ledgerTransactionId;
    }

    public void setLedgerTransactionId(String ledgerTransactionId) {
        this.ledgerTransactionId = ledgerTransactionId;
    }

    public String getMealPeriodId() {
        return mealPeriodId;
    }

    public void setMealPeriodId(String mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    /**
     * @return The id of the item
     */
    public String getTransactionItemId() {
        return transactionItemId;
    }

    /**
     * Set the id of the item
     */
    public void setTransactionItemId(String transactionItemId) {
        this.transactionItemId = transactionItemId;
    }

    /**
     * @return the name of the accounting item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the name of the accountin item
     *
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return The amount of the item
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Set the amount of the item
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public NightAuditTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(NightAuditTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getLedger() {
        return ledger;
    }

    public void setLedger(String ledger) {
        this.ledger = ledger;
    }

    public String getDestinationLedger() {
        return destinationLedger;
    }

    public void setDestinationLedger(String destinationLedger) {
        this.destinationLedger = destinationLedger;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceLedger() {
        return sourceLedger;
    }

    public void setSourceLedger(String sourceLedger) {
        this.sourceLedger = sourceLedger;
    }

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public DateTime getPostingCalendarDateTime() {
        return postingCalendarDateTime;
    }

    public void setPostingCalendarDateTime(DateTime postingCalendarDateTime) {
        this.postingCalendarDateTime = postingCalendarDateTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
