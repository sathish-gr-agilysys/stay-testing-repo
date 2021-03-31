/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class LedgertransactionMutable {

    private String receiptTextImage;

    public static final String RECEIPT_TEXT_IMAGE = "receiptTextImage";

    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }
}
