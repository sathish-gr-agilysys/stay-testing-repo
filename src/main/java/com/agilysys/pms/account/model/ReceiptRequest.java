package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptRequest implements Receipt {
    @JsonProperty(required = true)
    private String receiptText;

    @Override
    public String getReceiptText() {
        return receiptText;
    }

    @Override
    public void setReceiptText(String receiptText) {
        this.receiptText = receiptText;
    }
}