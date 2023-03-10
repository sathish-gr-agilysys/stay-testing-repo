/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.common.model.rate.AllowanceCombination;

public class PosCredit extends Credit implements PosTransaction, TrackableTransaction {
    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;
    private long paymentMethodId;

    public PosCredit() {}

    public PosCredit(PosCredit posCredit) {
        receiptTextImage = posCredit.getReceiptTextImage();
        checkNumber = posCredit.getCheckNumber();
        closeTime = posCredit.getCloseTime();
        setTransactionItemType(posCredit.getTransactionItemType());
        setMealPeriodId(posCredit.getMealPeriodId());
        setExpectedGrossAmount(posCredit.getExpectedGrossAmount());
        setAccountId(posCredit.getAccountId());
        setAmount(posCredit.getAmount());
        setIgnoreRules(posCredit.getIgnoreRules());
        setItemId(posCredit.getItemId());
        setParentId(posCredit.getParentId());
        setPostingDate(posCredit.getPostingDate());
        setQuantity(posCredit.getQuantity());
        setReason(posCredit.getReason());
        setReference(posCredit.getReference());
        setSourceId(posCredit.getSourceId());
        setTerminalId(posCredit.getTerminalId());
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

    @Override
    public String getCloseTime() {
        return closeTime;
    }

    @Override
    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    @Override
    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    //TODO-23333 verify
//    @Override
//    public boolean checkPosCharge() {
//        return true;
//    }

    @Override
    public AllowanceCombination toAllowanceCombination() {
        if (mealPeriodId == null || sourceId == null || itemId == null) {
            return null;
        }
        return new AllowanceCombination(mealPeriodId, sourceId, itemId);
    }
}
