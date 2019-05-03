/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

import com.agilysys.pms.payment.model.CardInformation;
import com.agilysys.pms.payment.model.GatewayType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payment
 */
public class Payment {
    @JsonProperty(required = true)
    private List<PaymentTransaction> transactions;
    @JsonProperty(required = true)
    private String paymentMethodId;
    private String paymentInstrumentId;
    private CardInformation cardInformation;
    private String terminalId;
    private String invoiceNumber;
    private GatewayType gatewayType;

    public Payment() {
        this.transactions = new ArrayList<>();
    }

    public Payment(String paymentMethodId, String terminalId, String invoiceNumber, String paymentInstrumentId,
                   List<PaymentTransaction> transactions) {
        this.paymentMethodId = paymentMethodId;
        this.terminalId = terminalId;
        this.invoiceNumber = invoiceNumber;
        this.paymentInstrumentId = paymentInstrumentId;
        this.transactions = transactions;
    }

    public Payment(ApplyInvoicePaymentRequest applyInvoicePaymentRequest) {
        paymentInstrumentId = applyInvoicePaymentRequest.getPaymentInstrumentId();
        paymentMethodId = applyInvoicePaymentRequest.getPaymentMethodId();
        terminalId = applyInvoicePaymentRequest.getTerminalId();
        invoiceNumber = applyInvoicePaymentRequest.getInvoiceNumber();

        transactions = applyInvoicePaymentRequest.getInvoicePayments() != null ?
              new ArrayList<>(applyInvoicePaymentRequest.getInvoicePayments()) : null;
    }

    public List<PaymentTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<PaymentTransaction> transactions) {
        this.transactions = transactions;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public CardInformation getCardInformation() {
        return cardInformation;
    }

    public void setCardInformation(CardInformation cardInformation) {
        this.cardInformation = cardInformation;
    }

    public String getPaymentInstrumentId() {
        return paymentInstrumentId;
    }

    public void setPaymentInstrumentId(String paymentInstrumentId) {
        this.paymentInstrumentId = paymentInstrumentId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public GatewayType getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(GatewayType gatewayType) {
        this.gatewayType = gatewayType;
    }
}
