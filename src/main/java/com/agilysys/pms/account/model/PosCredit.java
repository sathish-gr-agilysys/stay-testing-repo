/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCredit extends Credit implements PosTransaction {
    private String receiptTextImage;
    private String checkNumber;

    @Override
    public String getCheckNumber() {
        return checkNumber;
    }

    @Override
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    @Override
    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }
}
