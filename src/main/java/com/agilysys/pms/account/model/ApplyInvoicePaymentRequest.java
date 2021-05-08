/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object used to apply payments to one or more A/R invoices
 */
public class ApplyInvoicePaymentRequest {
    @JsonProperty(required = true)
    private List<InvoicePaymentRequest> invoicePayments = new ArrayList<>();
    @JsonProperty(required = true)
    private PaymentSettingRequest paymentSettingRequest;
    private boolean saveThisCardToAccount;
    // fields that need to be provided when the payment method is of type Credit Card
    private String terminalId;
    private String invoiceNumber;
    private boolean includeDisputes;
    private String disputeComment;

    public void setInvoicePayments(List<InvoicePaymentRequest> invoicePayments) {
        this.invoicePayments = invoicePayments;
    }

    public List<InvoicePaymentRequest> getInvoicePayments() {
        return invoicePayments;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
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

    public PaymentSettingRequest getPaymentSettingRequest() {
        return paymentSettingRequest;
    }

    public void setPaymentSettingRequest(PaymentSettingRequest paymentSettingRequest) {
        this.paymentSettingRequest = paymentSettingRequest;
    }

    public boolean isSaveThisCardToAccount() {
        return saveThisCardToAccount;
    }

    public void setSaveThisCardToAccount(boolean saveThisCardToAccount) {
        this.saveThisCardToAccount = saveThisCardToAccount;
    }
}
