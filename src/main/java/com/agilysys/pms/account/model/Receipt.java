package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Receipt {
    String getReceiptText();
    void setReceiptText(String receiptText);
}
