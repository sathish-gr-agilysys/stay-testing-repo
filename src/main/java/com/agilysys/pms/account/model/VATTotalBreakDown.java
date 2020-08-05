/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agilysys.common.template.TemplateData;
import com.agilysys.pms.account.model.TaxBreakDown;

public class VATTotalBreakDown implements TemplateData {

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

    @Override
    public Map<String, Object> rawFields() {
        Map<String, Object> rawFieldMap = new HashMap<>(3);
        if (totalNet != null) {
            rawFieldMap.put(TemplateData.rawField("totalNet"), totalNet);
        }
        if (totalVat != null) {
            rawFieldMap.put(TemplateData.rawField("totalVat"), totalVat);
        }
        if (totalGross != null) {
            rawFieldMap.put(TemplateData.rawField("totalGross"), totalGross);
        }

        return rawFieldMap;
    }
}
