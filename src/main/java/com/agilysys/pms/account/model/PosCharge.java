/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCharge extends Charge implements PosTransaction, TrackableTransaction {
    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;

    @Override
    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    @Override
    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }

    @Override
    public Long getCheckNumber() {
        return checkNumber;
    }

    @Override
    public void setCheckNumber(Long checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String getCloseTime() {
        return closeTime;
    }

    @Override
    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public boolean checkPosCharge() {
        return true;
    }
}
