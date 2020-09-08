/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public class EstimatedChargeDetailsForOffers {
    Map<LocalDate, List<RecurringChargeView>> recurringChargeViewsByDate;
    Map<String, BigDecimal> offerWiseAmountSplit;
    Map<String, BigDecimal> offerWiseTaxSplit;

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
}
