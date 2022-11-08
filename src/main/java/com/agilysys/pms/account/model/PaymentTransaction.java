/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

public class PaymentTransaction extends Transaction implements TrackableTransaction {
    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;
    private String lineItemId;

    public PaymentTransaction() {}

    public PaymentTransaction(String accountId, BigDecimal amount, String itemId) {
        this.accountId = accountId;
        this.amount = amount;
        this.itemId = itemId;
    }

    public PaymentTransaction(String accountId, BigDecimal amount, String itemId, String receiptTextImage,
          Long checkNumber, String closeTime, String sourceId, String reason) {
        this(accountId, amount, itemId);
        this.receiptTextImage = receiptTextImage;
        this.checkNumber = checkNumber;
        this.closeTime = closeTime;
        super.sourceId = sourceId;
        super.reason = reason;
    }

    public PaymentTransaction(String accountId, BigDecimal amount, String folioId, boolean ignoreRules, String itemId,
          LocalDate postingDate, String reason, String referenceNumber) {
        this(accountId, amount, itemId);
        this.folioId = folioId;
        this.ignoreRules = ignoreRules;
        this.postingDate = postingDate;
        this.reason = reason;
        this.referenceNumber = referenceNumber;
    }

    public void toTransaction(String accountId, String folioId, Boolean pantryItem) {
        this.accountId = accountId;
        this.folioId = folioId;
        this.pantryItem = pantryItem;
    }

    @Override
    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    @Override
    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }

    @Override
    public Long getCheckNumber() {
        return checkNumber;
    }

    @Override
    public void setCheckNumber(Long checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String getCloseTime() {
        return closeTime;
    }

    @Override
    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }
}
