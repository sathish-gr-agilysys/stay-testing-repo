/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class LineItemWithAmountUsed {

    private String lineItemId;
    private BigDecimal amountUsed;

    public LineItemWithAmountUsed() {
    }

    public LineItemWithAmountUsed(String lineItemId, BigDecimal amountUsed) {
        this.lineItemId = lineItemId;
        this.amountUsed = amountUsed;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public BigDecimal getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(BigDecimal amountUsed) {
        this.amountUsed = amountUsed;
    }
}
