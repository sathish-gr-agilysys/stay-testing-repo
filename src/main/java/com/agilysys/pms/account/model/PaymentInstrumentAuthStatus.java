/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.payment.model.PaymentInstrumentView;

/**
 * POJO intended to communicate the results of a credit card authorization
 * including the PaymentInstrumentView from payment-service, the status,
 * error code, and payment setting id.
 */
public class PaymentInstrumentAuthStatus {
    private String paymentSettingId;
    private PaymentInstrumentView paymentInstrumentView;
    private String errorMessage;
    private Boolean success;

    public PaymentInstrumentAuthStatus() {
    }

    public PaymentInstrumentAuthStatus(String paymentSettingId, Boolean success,
          PaymentInstrumentView paymentInstrumentView) {
        this.paymentSettingId = paymentSettingId;
        this.paymentInstrumentView = paymentInstrumentView;
        this.success = success;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }

    public PaymentInstrumentView getPaymentInstrumentView() {
        return paymentInstrumentView;
    }

    public void setPaymentInstrumentView(PaymentInstrumentView paymentInstrumentView) {
        this.paymentInstrumentView = paymentInstrumentView;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
