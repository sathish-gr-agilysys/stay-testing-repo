/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class ChargeTaxAmountInfo {
    private BigDecimal totalTaxAmount;

    private List<TaxAmountInfo> taxAmountInfoList;

    /**
     * the sum of all tax amounts
     */
    public BigDecimal getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public List<TaxAmountInfo> getTaxAmountInfoList() {
        return taxAmountInfoList;
    }

    public void setTaxAmountInfoList(List<TaxAmountInfo> taxAmountInfoList) {
        this.taxAmountInfoList = taxAmountInfoList;
    }
}
