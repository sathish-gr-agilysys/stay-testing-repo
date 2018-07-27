/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCredit extends Credit implements PosTransaction {
    private String receiptText;
    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

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
