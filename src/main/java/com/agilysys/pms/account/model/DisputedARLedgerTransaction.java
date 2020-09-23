/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.pms.comment.model.Comment;

public class DisputedARLedgerTransaction {

    private String ledgerTransactionId;
    private boolean dispute;
    private Comment comment;
    private String id;
    private String itemId;
    private String invoiceNumber;
    private BigDecimal amount;

    public DisputedARLedgerTransaction() { }

    public DisputedARLedgerTransaction(String ledgerTransactionId, boolean dispute, Comment comment) {
        this.ledgerTransactionId = ledgerTransactionId;
        this.dispute = dispute;
        this.comment = comment;
    }

    public DisputedARLedgerTransaction(String ledgerTransactionId, boolean dispute, Comment comment, String itemId,
          String invoiceNumber, BigDecimal amount) {
        this(ledgerTransactionId, dispute, comment);
        this.itemId = itemId;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
    }

    public String getLedgerTransactionId() {
        return ledgerTransactionId;
    }

    public void setLedgerTransactionId(String ledgerTransactionId) {
        this.ledgerTransactionId = ledgerTransactionId;
    }

    public boolean isDispute() {
        return dispute;
    }

    public void setDispute(boolean dispute) {
        this.dispute = dispute;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
