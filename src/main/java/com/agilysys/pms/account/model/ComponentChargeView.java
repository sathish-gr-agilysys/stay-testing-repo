/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;


public class ComponentChargeView {

    private String componentBundleId;

    private String transactionItemId;

    private BigDecimal amount;

    private int quantity;

    ChargeTaxAmountInfo estimatedTaxInfo;

    public String getComponentBundleId() {
        return componentBundleId;
    }

    public void setComponentBundleId(String componentBundleId) {
        this.componentBundleId = componentBundleId;
    }

    public String getTransactionItemId() {
        return transactionItemId;
    }

    public void setTransactionItemId(String transactionItemId) {
        this.transactionItemId = transactionItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ChargeTaxAmountInfo getEstimatedTaxInfo() {
        return estimatedTaxInfo;
    }

    public void setEstimatedTaxInfo(ChargeTaxAmountInfo estimatedTaxInfo) {
        this.estimatedTaxInfo = estimatedTaxInfo;
    }
}
