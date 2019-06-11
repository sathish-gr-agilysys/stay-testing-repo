/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import com.agilysys.pms.account.model.TaxBreakDown;

public class VATTotalBreakDown {

    private List<TaxBreakDown> taxBreakDowns;
    private BigDecimal totalNet;
    private BigDecimal totalVat;
    private BigDecimal totalGross;
    private String formattedTotalNet;
    private String formattedTotalVat;
    private String formattedTotalGross;

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

    public String getFormattedTotalNet() {
        return formattedTotalNet;
    }

    public void setFormattedTotalNet(String formattedTotalNet) {
        this.formattedTotalNet = formattedTotalNet;
    }

    public String getFormattedTotalVat() {
        return formattedTotalVat;
    }

    public void setFormattedTotalVat(String formattedTotalVat) {
        this.formattedTotalVat = formattedTotalVat;
    }

    public String getFormattedTotalGross() {
        return formattedTotalGross;
    }

    public void setFormattedTotalGross(String formattedTotalGross) {
        this.formattedTotalGross = formattedTotalGross;
    }
}
