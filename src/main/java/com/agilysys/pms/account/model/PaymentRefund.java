/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request model sent in in order to refund a particular payment
 */
public class PaymentRefund {
    @JsonProperty(required = true)
    private String folioLineItemId;

    @JsonProperty(required = true)
    private BigDecimal refundAmount;

    @Max(250)
    private String reason;

    private String terminalId;
    private String invoiceNumber;
    private String reference;
    private Map<String, String> transactionMessageAttributes;
    private String gatewayType;
    private String giftCardNumber;
    private String tracke;
    private String encMode;
    private Boolean cardPresent;

    public String getFolioLineItemId() {
        return folioLineItemId;
    }

    public void setFolioLineItemId(String folioLineItemId) {
        this.folioLineItemId = folioLineItemId;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Map<String, String> getTransactionMessageAttributes() {
        return transactionMessageAttributes;
    }

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public String getGiftCardNumber() {
        return giftCardNumber;
    }

    public void setGiftCardNumber(String giftCardNumber) {
        this.giftCardNumber = giftCardNumber;
    }

    public String getTracke() {
        return tracke;
    }

    public void setTracke(String tracke) {
        this.tracke = tracke;
    }

    public String getEncMode() {
        return encMode;
    }

    public void setEncMode(String encMode) {
        this.encMode = encMode;
    }

    public Boolean getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(Boolean cardPresent) {
        this.cardPresent = cardPresent;
    }
}
