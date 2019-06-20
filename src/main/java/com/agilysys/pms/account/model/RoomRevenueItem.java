/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoomRevenueItem {
    private String accountId;
    private String referenceId;
    private BigDecimal amount;

    public RoomRevenueItem() {
        amount = BigDecimal.ZERO;
    }

    public RoomRevenueItem(String accountId, String referenceId, BigDecimal amount) {
        this.accountId = accountId;
        this.referenceId = referenceId;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public BigDecimal getAmount() {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
