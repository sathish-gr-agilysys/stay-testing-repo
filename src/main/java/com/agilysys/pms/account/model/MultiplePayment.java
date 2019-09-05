/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

public class MultiplePayment {
    private Map<String, String> reservationAccountIdMap;
    private BigDecimal amount;

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

}
