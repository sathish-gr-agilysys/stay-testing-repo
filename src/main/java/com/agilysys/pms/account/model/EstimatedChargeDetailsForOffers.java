/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public class EstimatedChargeDetailsForOffers {
    private Map<LocalDate, List<RecurringChargeView>> recurringChargeViewsByDate;
    private Map<String, BigDecimal> offerWiseAmountSplit;
    private Map<String, BigDecimal> offerWiseTaxSplit;
    private BigDecimal originalAmount;
    private BigDecimal originalTaxAmount;

    public Map<LocalDate, List<RecurringChargeView>> getRecurringChargeViewsByDate() {
        return recurringChargeViewsByDate;
    }

    public void setRecurringChargeViewsByDate(Map<LocalDate, List<RecurringChargeView>> recurringChargeViewsByDate) {
        this.recurringChargeViewsByDate = recurringChargeViewsByDate;
    }

    public Map<String, BigDecimal> getOfferWiseAmountSplit() {
        return offerWiseAmountSplit;
    }

    public void setOfferWiseAmountSplit(Map<String, BigDecimal> offerWiseAmountSplit) {
        this.offerWiseAmountSplit = offerWiseAmountSplit;
    }

    public Map<String, BigDecimal> getOfferWiseTaxSplit() {
        return offerWiseTaxSplit;
    }

    public void setOfferWiseTaxSplit(Map<String, BigDecimal> offerWiseTaxSplit) {
        this.offerWiseTaxSplit = offerWiseTaxSplit;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getOriginalTaxAmount() {
        return originalTaxAmount;
    }

    public void setOriginalTaxAmount(BigDecimal originalTaxAmount) {
        this.originalTaxAmount = originalTaxAmount;
    }
}
