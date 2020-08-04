/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class InvoicePaymentHistory extends BaseInvoiceHistory {

    private String paymentMethod;
    private BigDecimal totalAmount;
    private String reference;
    private String paymentReferenceId;
    private String paymentMethodId;

    public InvoicePaymentHistory() {
    }

    public InvoicePaymentHistory(String eventType, String invoiceNumber, DateTime invoiceDate, String userId,
          String paymentMethod, BigDecimal totalAmount, String reference, String paymentReferenceId,
          String paymentMethodId) {
        super(eventType, invoiceNumber, invoiceDate, userId);
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.reference = reference;
        this.paymentReferenceId = paymentReferenceId;
        this.paymentMethodId = paymentMethodId;
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

    public String getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
