/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCharge extends Charge implements PosTransaction {
    private String receiptText;
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
    public String getReceiptText() {
        return receiptText;
    }

    @Override
    public void setReceiptText(String receiptText) {
        this.receiptText = receiptText;
    }
}
