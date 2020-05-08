/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class ARDepositView {

    private BigDecimal depositAmount;
    private BigDecimal depositBalance;

    public ARDepositView() {
    }

    public ARDepositView(BigDecimal depositAmount, BigDecimal depositBalance) {
        this.depositAmount = depositAmount;
        this.depositBalance = depositBalance;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public void setDepositBalance(BigDecimal depositBalance) {
        this.depositBalance = depositBalance;
    }
}
