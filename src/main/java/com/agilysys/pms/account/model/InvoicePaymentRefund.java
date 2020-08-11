/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request model object used to refund a payment applied on an invoice
 */
public class InvoicePaymentRefund extends PaymentRefund {
    @JsonProperty(required = true)
    private String invoicePaymentId;

    public String getInvoicePaymentId() {
        return invoicePaymentId;
    }

    public void setInvoicePaymentId(String invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
    }
}
