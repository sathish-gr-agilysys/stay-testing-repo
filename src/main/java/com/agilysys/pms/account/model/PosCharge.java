/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCharge extends Charge implements PosTransaction {
    private String receiptTextImage;
    private Long checkNumber;

    @Override
    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    @Override
    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }

    public Long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Long checkNumber) {
        this.checkNumber = checkNumber;
    }
}
