/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PosCredit extends Credit implements PosTransaction {
    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;

    public PosCredit() {}

    public PosCredit(PosCredit posCredit) {
        this.receiptTextImage = posCredit.getReceiptTextImage();
        this.checkNumber = posCredit.getCheckNumber();
        this.closeTime = posCredit.getCloseTime();
        this.setTransactionItemType(posCredit.getTransactionItemType());
        this.setMealPeriodId(posCredit.getMealPeriodId());
        this.setExpectedGrossAmount(posCredit.getExpectedGrossAmount());
        this.setAccountId(posCredit.getAccountId());
        this.setAmount(posCredit.getAmount());
        this.setIgnoreRules(posCredit.getIgnoreRules());
        this.setItemId(posCredit.getItemId());
        this.setParentId(posCredit.getParentId());
        this.setPostingDate(posCredit.getPostingDate());
        this.setQuantity(posCredit.getQuantity());
        this.setReason(posCredit.getReason());
        this.setReference(posCredit.getReference());
        this.setSourceId(posCredit.getSourceId());
        this.setTerminalId(posCredit.getTerminalId());
    }

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

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public boolean checkPosCharge() {
        return true;
    }
}