/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account;

import java.math.BigDecimal;
import java.util.List;

import com.agilysys.pms.account.model.TaxBreakDown;

public class VATTotalBreakDown {

    private List<TaxBreakDown> taxBreakDowns;
    private BigDecimal totalNet;
    private BigDecimal totalVat;
    private BigDecimal totalGross;

    public List<TaxBreakDown> getTaxBreakDowns() {
        return taxBreakDowns;
    }

    public void setTaxBreakDowns(List<TaxBreakDown> taxBreakDowns) {
        this.taxBreakDowns = taxBreakDowns;
    }

    public BigDecimal getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(BigDecimal totalNet) {
        this.totalNet = totalNet;
    }

    public BigDecimal getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(BigDecimal totalVat) {
        this.totalVat = totalVat;
    }

    public BigDecimal getTotalGross() {
        return totalGross;
    }

    public void setTotalGross(BigDecimal totalGross) {
        this.totalGross = totalGross;
    }
}
