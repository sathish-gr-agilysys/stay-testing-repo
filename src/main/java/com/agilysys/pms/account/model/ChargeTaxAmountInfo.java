/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ChargeTaxAmountInfo {
    private BigDecimal totalTaxAmount;

    private List<TaxAmountInfo> taxAmountInfoList;

    private BigDecimal offerAmt;

    private BigDecimal offerAppliedAmt;

    public ChargeTaxAmountInfo() {
        taxAmountInfoList = Collections.EMPTY_LIST;
        totalTaxAmount = BigDecimal.ZERO;
    }

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

    public BigDecimal getOfferAmt() {
        return offerAmt;
    }

    public void setOfferAmt(BigDecimal offerAmt) {
        this.offerAmt = offerAmt;
    }

    public BigDecimal getOfferAppliedAmt() {
        return offerAppliedAmt;
    }

    public void setOfferAppliedAmt(BigDecimal offerAppliedAmt) {
        this.offerAppliedAmt = offerAppliedAmt;
    }
}
