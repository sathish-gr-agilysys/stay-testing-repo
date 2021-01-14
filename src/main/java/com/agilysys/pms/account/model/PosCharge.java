/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCharge extends Charge implements PosTransaction {
    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;
    private boolean ignoreAuth;

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

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public boolean isIgnoreAuth() {
        return ignoreAuth;
    }

    public void setIgnoreAuth(boolean ignoreAuth) {
        this.ignoreAuth = ignoreAuth;
    }

    @Override
    public boolean checkPosCharge() {
        return true;
    }
}
