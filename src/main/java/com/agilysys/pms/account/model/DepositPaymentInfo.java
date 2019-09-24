package com.agilysys.pms.account.model;

/**
 * Created by JaffaralliH on 9/23/2019.
 */
public class DepositPaymentInfo extends Payment {
    String scheduleDepositId;

    public String getScheduleDepositId() {
        return scheduleDepositId;
    }

    public void setScheduleDepositId(String scheduleDepositId) {
        this.scheduleDepositId = scheduleDepositId;
    }
}
