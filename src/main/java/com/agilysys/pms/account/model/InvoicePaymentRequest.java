/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object used to apply a payment an A/R invoice
 */
public class InvoicePaymentRequest extends PaymentTransaction {
    @JsonProperty(required = true)
    private String invoiceId;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
