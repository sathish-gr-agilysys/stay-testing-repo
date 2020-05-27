/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class CompRedeemRequest {
    private String lineItemId;
    private String itemId;
    private List<String> taxClasses;
    private BigDecimal amount;

    public CompRedeemRequest() {
    }

    public CompRedeemRequest(String lineItemId, String itemId, List<String> taxClasses, BigDecimal amount) {
        this.lineItemId = lineItemId;
        this.itemId = itemId;
        this.taxClasses = taxClasses;
        this.amount = amount;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<String> getTaxClasses() {
        return taxClasses;
    }

    public void setTaxClasses(List<String> taxClasses) {
        this.taxClasses = taxClasses;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
