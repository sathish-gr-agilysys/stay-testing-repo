package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptRequest implements Receipt {
    @JsonProperty(required = true)
    private String receiptTextImage;

    @Override
    public String getReceiptText() {
        return receiptTextImage;
    }

    @Override
    public void setReceiptText(String receiptText) {
        this.receiptTextImage = receiptText;
    }
}