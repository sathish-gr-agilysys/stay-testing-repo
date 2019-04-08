package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

/**
 * Represents an item that is to be included in revenue reports
 */
public class RevenueReportItem {
    private String transactionId;
    private String accountId;
    private String accountType;
    private String referenceId;
    private String itemId;
    private BigDecimal amount;
    private LocalDate postingPropertyDate;
    private boolean roomRevenue;
    private boolean posted;

    public RevenueReportItem() {
    }

    public RevenueReportItem(RevenueReportItem revenueReportItem) {
        transactionId = revenueReportItem.transactionId;
        accountId = revenueReportItem.accountId;
        accountType = revenueReportItem.accountType;
        referenceId = revenueReportItem.referenceId;
        itemId = revenueReportItem.itemId;
        amount = revenueReportItem.amount;
        postingPropertyDate = revenueReportItem.postingPropertyDate;
        roomRevenue = revenueReportItem.roomRevenue;
        posted = revenueReportItem.posted;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public boolean isRoomRevenue() {
        return roomRevenue;
    }

    public void setRoomRevenue(boolean roomRevenue) {
        this.roomRevenue = roomRevenue;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }
}

