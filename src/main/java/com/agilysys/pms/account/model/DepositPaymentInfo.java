/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class DepositPaymentInfo extends Payment {
    String scheduleDepositId;
    String splitId;

    public DepositPaymentInfo() {
    }

    public DepositPaymentInfo(String scheduleDepositId, String splitId, String invoiceNumber,
          String paymentInstrumentId, String paymentMethodId, String terminalId,
          List<PaymentTransaction> transactions) {
        super(paymentMethodId, terminalId, invoiceNumber, paymentInstrumentId, transactions);
        this.scheduleDepositId = scheduleDepositId;
        this.splitId = splitId;
    }

    public String getScheduleDepositId() {
        return scheduleDepositId;
    }

    public void setScheduleDepositId(String scheduleDepositId) {
        this.scheduleDepositId = scheduleDepositId;
    }

    public String getSplitId() {
        return splitId;
    }

    public void setSplitId(String splitId) {
        this.splitId = splitId;
    }
}
