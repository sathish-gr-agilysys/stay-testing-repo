package com.agilysys.pms.account.model;

import com.agilysys.pms.common.batchdistributor.model.BatchDistributorResultBase;
import com.agilysys.pms.payment.model.PaymentInstrumentView;

public class BatchPreAuthResult extends BatchDistributorResultBase {
    private String tenantId;
    private String propertyId;
    private String reservationId;
    private PaymentInstrumentView paymentInstrumentView;

    public BatchPreAuthResult(){}

    public BatchPreAuthResult(String tenantId, String propertyId, String reservationId,
          PaymentInstrumentView paymentInstrumentView) {
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.reservationId = reservationId;
        this.paymentInstrumentView = paymentInstrumentView;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public PaymentInstrumentView getPaymentInstrumentView() {
        return paymentInstrumentView;
    }

    public void setPaymentInstrumentView(PaymentInstrumentView paymentInstrumentView) {
        this.paymentInstrumentView = paymentInstrumentView;
    }
}
