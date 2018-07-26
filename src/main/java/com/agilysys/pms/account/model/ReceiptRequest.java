package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptRequest implements Receipt {
    @JsonProperty(required = true)
    private String receiptTextImage;

    @Override
    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    @Override
    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }
}