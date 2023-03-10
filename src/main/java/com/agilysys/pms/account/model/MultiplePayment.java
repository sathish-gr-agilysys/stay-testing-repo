/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

public class MultiplePayment {
    private Map<String, String> reservationAccountIdMap;
    private BigDecimal amount;
    private String paymentMethodId;
    private String referenceNumber;
    private Boolean depositPaymentAtBooking;
    private CurrencyExchangeDetails currencyExchangeDetails;

    public MultiplePayment() {}

    public MultiplePayment(BigDecimal depositAmount, Map<String, String> reservationAccountMap) {
        this.amount = depositAmount;
        this.reservationAccountIdMap = reservationAccountMap;
    }

    public Map<String, String> getReservationAccountIdMap() {
        return reservationAccountIdMap;
    }

    public void setReservationAccountIdMap(Map<String, String> reservationAccountIdMap) {
        this.reservationAccountIdMap = reservationAccountIdMap;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Boolean getDepositPaymentAtBooking() {
        return depositPaymentAtBooking;
    }

    public void setDepositPaymentAtBooking(Boolean depositPaymentAtBooking) {
        this.depositPaymentAtBooking = depositPaymentAtBooking;
    }

    public CurrencyExchangeDetails getCurrencyExchangeDetails() {
        return currencyExchangeDetails;
    }

    public void setCurrencyExchangeDetails(CurrencyExchangeDetails currencyExchangeDetails) {
        this.currencyExchangeDetails = currencyExchangeDetails;
    }
}
