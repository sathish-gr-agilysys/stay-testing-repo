/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplyInvoiceDepositPaymentRequest {
    @JsonProperty(required = true)
    private List<InvoicePaymentRequest> invoicePayments = new ArrayList<>();
    private String invoiceNumber;
    private boolean includeDisputes;
    private String disputeComment;
    private Set<String> unappliedPaymentIds;
    private PaymentSettingRequest paymentSettingRequest;
    private String paymentMethodId;
    private String paymentInstrumentId;

    public List<InvoicePaymentRequest> getInvoicePayments() {
        return invoicePayments;
    }

    public void setInvoicePayments(List<InvoicePaymentRequest> invoicePayments) {
        this.invoicePayments = invoicePayments;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public boolean isIncludeDisputes() {
        return includeDisputes;
    }

    public void setIncludeDisputes(boolean includeDisputes) {
        this.includeDisputes = includeDisputes;
    }

    public String getDisputeComment() {
        return disputeComment;
    }

    public void setDisputeComment(String disputeComment) {
        this.disputeComment = disputeComment;
    }

    public Set<String> getUnappliedPaymentIds() {
        return unappliedPaymentIds;
    }

    public void setUnappliedPaymentIds(Set<String> unappliedPaymentIds) {
        this.unappliedPaymentIds = unappliedPaymentIds;
    }

    public PaymentSettingRequest getPaymentSettingRequest() {
        return paymentSettingRequest;
    }

    public void setPaymentSettingRequest(PaymentSettingRequest paymentSettingRequest) {
        this.paymentSettingRequest = paymentSettingRequest;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentInstrumentId() {
        return paymentInstrumentId;
    }

    public void setPaymentInstrumentId(String paymentInstrumentId) {
        this.paymentInstrumentId = paymentInstrumentId;
    }
}
