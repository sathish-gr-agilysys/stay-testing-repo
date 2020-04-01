/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public abstract class TaxableTransaction extends Transaction {
    //charge + tax should match this expectedGrossAmount
    private BigDecimal expectedGrossAmount;

    public BigDecimal getExpectedGrossAmount() {
        return expectedGrossAmount;
    }

    public void setExpectedGrossAmount(BigDecimal expectedGrossAmount) {
        this.expectedGrossAmount = expectedGrossAmount;
    }
}
