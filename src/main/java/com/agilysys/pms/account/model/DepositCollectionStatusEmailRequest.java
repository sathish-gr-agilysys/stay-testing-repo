package com.agilysys.pms.account.model;

public class DepositCollectionStatusEmailRequest {
    private boolean paymentSuccess;
    private String scheduledDepositId;
    private String paymentInstrumentId;
    private String paymentMethodId;

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

    public String getPaymentInstrumentId() {
        return paymentInstrumentId;
    }

    public void setPaymentInstrumentId(String paymentInstrumentId) {
        this.paymentInstrumentId = paymentInstrumentId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
