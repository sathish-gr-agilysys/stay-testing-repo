package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Receipt {
    String getReceiptTextImage();
    void setReceiptTextImage(String receiptTextImage);
}
