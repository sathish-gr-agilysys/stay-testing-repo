/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;

@AuditEntity(EntityTypes.THRESHOLD_AMOUNT)
public class ThresholdAmount extends AccountingItem {

    private static final String DISPLAY_NAME = "Threshold amount configuration";

    private BigDecimal transactionItemThresholdLimit;

    private BigDecimal paymentMethodThresholdLimit;

    public ThresholdAmount(){}

    public BigDecimal getTransactionItemThresholdLimit() {
        return transactionItemThresholdLimit;
    }

    public void setTransactionItemThresholdLimit(BigDecimal transactionItemThresholdLimit) {
        this.transactionItemThresholdLimit = transactionItemThresholdLimit;
    }

    public BigDecimal getPaymentMethodThresholdLimit() {
        return paymentMethodThresholdLimit;
    }

    public void setPaymentMethodThresholdLimit(BigDecimal paymentMethodThresholdLimit) {
        this.paymentMethodThresholdLimit = paymentMethodThresholdLimit;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
