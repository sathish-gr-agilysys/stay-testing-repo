/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.common.template.TemplateData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TaxBreakDown implements TemplateData {
    private String taxRule;
    private BigDecimal net;
    private BigDecimal vat;
    private BigDecimal gross;

    public TaxBreakDown() {}

    public TaxBreakDown(String taxRule, BigDecimal net, BigDecimal vat, BigDecimal gross) {
        this.taxRule = taxRule;
        this.net = net;
        this.vat = vat;
        this.gross = gross;
    }

    public String getTaxRule() {
        return taxRule;
    }

    public void setTaxRule(String taxRule) {
        this.taxRule = taxRule;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    @Override
    public Map<String, Object> rawFields() {
        Map<String, Object> rawFieldMap = new HashMap<>(3);
        if (net != null) {
            rawFieldMap.put(TemplateData.rawField("net"), net);
        }
        if (vat != null) {
            rawFieldMap.put(TemplateData.rawField("vat"), vat);
        }
        if (gross != null) {
            rawFieldMap.put(TemplateData.rawField("gross"), gross);
        }

        return rawFieldMap;
    }
}
