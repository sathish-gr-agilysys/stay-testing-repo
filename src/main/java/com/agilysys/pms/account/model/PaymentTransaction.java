/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

/**
 * Needed because transaction is abstract
 */
public class PaymentTransaction extends Transaction {
    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;

    public PaymentTransaction() {
    }

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

    public void toTransaction(String accountId, String folioId, Boolean pantryItem) {
        this.accountId = accountId;
        this.folioId = folioId;
        this.pantryItem = pantryItem;
    }

    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }

    public Long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Long checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

}