/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public interface TrackableTransaction {
    String getReceiptTextImage();
    void setReceiptTextImage(String receiptTextImage);

    Long getCheckNumber();
    void setCheckNumber(Long checkNumber);

    String getCloseTime();
    void setCloseTime(String closeTime);
}
