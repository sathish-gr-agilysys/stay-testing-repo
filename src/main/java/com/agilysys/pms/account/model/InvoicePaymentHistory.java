/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

public class InvoicePaymentHistory extends BaseInvoiceHistory {

    private String paymentMethod;
    private BigDecimal totalAmount;
    private String reference;

    public InvoicePaymentHistory() {
    }

    public InvoicePaymentHistory(String eventType, String invoiceNumber, LocalDate invoiceDate, String userId,
          String paymentMethod, BigDecimal totalAmount, String reference) {
        super(eventType, invoiceNumber, invoiceDate, userId);
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.reference = reference;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
