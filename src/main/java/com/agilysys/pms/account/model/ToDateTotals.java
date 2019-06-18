package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * MTD and YTD amounts
 */
public class ToDateTotals {
    private BigDecimal monthToDate;
    private BigDecimal yearToDate;

    // totalsByCashier will only be populated if requested by client
    /**
     * MTD and YTD totals broken down by userId
     */
    private Map<String, ToDateTotals> totalsByCashier;

    public BigDecimal getMonthToDate() {
        return monthToDate;
    }

    public void setMonthToDate(BigDecimal monthToDate) {
        this.monthToDate = monthToDate;
    }

    public BigDecimal getYearToDate() {
        return yearToDate;
    }

    public void setYearToDate(BigDecimal yearToDate) {
        this.yearToDate = yearToDate;
    }

    public Map<String, ToDateTotals> getTotalsByCashier() {
        return totalsByCashier;
    }

    public void setTotalsByCashier(Map<String, ToDateTotals> totalsByCashier) {
        this.totalsByCashier = totalsByCashier;
    }
}
