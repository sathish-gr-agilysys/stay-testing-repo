/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class DepositCollectionStatusEmailRequest {
    private boolean paymentSuccess;
    private String scheduledDepositId;
    private String splitId;

    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    public void setPaymentSuccess(boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }

    public String getScheduledDepositId() {
        return scheduledDepositId;
    }

    public void setScheduledDepositId(String scheduledDepositId) {
        this.scheduledDepositId = scheduledDepositId;
    }

    public String getSplitId() {
        return splitId;
    }

    public void setSplitId(String splitId) {
        this.splitId = splitId;
    }
}
