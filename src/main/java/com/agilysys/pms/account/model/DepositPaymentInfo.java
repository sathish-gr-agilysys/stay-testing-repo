/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class DepositPaymentInfo extends Payment {
    String scheduleDepositId;

    public String getScheduleDepositId() {
        return scheduleDepositId;
    }

    public void setScheduleDepositId(String scheduleDepositId) {
        this.scheduleDepositId = scheduleDepositId;
    }
}
