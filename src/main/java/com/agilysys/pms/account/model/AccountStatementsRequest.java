/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.pms.payment.model.PaymentFlowType;

public class AccountStatementsRequest {
    private Map<String, String> reservationConfirmationCodeByAccountId;
    private LocalDate propertyDate;
    private Set<String> accountIds;
    private Map<String, Charge> accountsChargesMap;
    private PaymentFlowType paymentFlowType;

    public Map<String, String> getReservationConfirmationCodeByAccountId() {
        return reservationConfirmationCodeByAccountId;
    }

    public void setReservationConfirmationCodeByAccountId(Map<String, String> reservationConfirmationCodeByAccountId) {
        this.reservationConfirmationCodeByAccountId = reservationConfirmationCodeByAccountId;
    }

    public LocalDate getPropertyDate() {
        return propertyDate;
    }

    public void setPropertyDate(LocalDate propertyDate) {
        this.propertyDate = propertyDate;
    }

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Map<String, Charge> getAccountsChargesMap() {
        return accountsChargesMap;
    }

    public void setAccountsChargesMap(Map<String, Charge> accountsChargesMap) {
        this.accountsChargesMap = accountsChargesMap;
    }

    public PaymentFlowType getPaymentFlowType() {
        return paymentFlowType;
    }

    public void setPaymentFlowType(PaymentFlowType paymentFlowType) {
        this.paymentFlowType = paymentFlowType;
    }
}
