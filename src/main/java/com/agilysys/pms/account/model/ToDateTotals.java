/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * MTD and YTD amounts
 */
public class ToDateTotals {
    private BigDecimal monthToDate;
    private BigDecimal yearToDate;
	private BigDecimal monthToDateTax;
    private BigDecimal yearToDateTax;

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
	
	public BigDecimal getMonthToDateTax() {
        return monthToDateTax;
    }

    public void setMonthToDateTax(BigDecimal monthToDateTax) {
        this.monthToDateTax = monthToDateTax;
    }

    public BigDecimal getYearToDateTax() {
        return yearToDateTax;
    }

    public void setYearToDateTax(BigDecimal yearToDateTax) {
        this.yearToDateTax = yearToDateTax;
    }
}
