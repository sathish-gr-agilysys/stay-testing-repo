/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class IGTransactionHistoryFields {

    private String receiptTextImage;
    private Long checkNumber;
    private String closeTime;
    private String sourceId;

    public IGTransactionHistoryFields() {}

    public IGTransactionHistoryFields(String receiptTextImage, Long checkNumber, String closeTime, String sourceId) {
        this.receiptTextImage = receiptTextImage;
        this.checkNumber = checkNumber;
        this.closeTime = closeTime;
        this.sourceId = sourceId;
    }

    public String getReceiptTextImage() {
        return receiptTextImage;
    }

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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
