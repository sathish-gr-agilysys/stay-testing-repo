/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.common.model.PaymentMethodSetting;

public class PaymentSettingRequest {
    private PaymentMethodSetting paymentMethodSetting;
    private String correlationId;
    private String paymentSettingId;

    public PaymentMethodSetting getPaymentMethodSetting() {
        return paymentMethodSetting;
    }

    public void setPaymentMethodSetting(PaymentMethodSetting paymentMethodSetting) {
        this.paymentMethodSetting = paymentMethodSetting;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }
}
