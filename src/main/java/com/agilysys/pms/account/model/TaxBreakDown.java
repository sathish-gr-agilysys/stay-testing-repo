/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class TaxBreakDown {
    private String taxRule;
    private BigDecimal net;
    private BigDecimal vat;
    private BigDecimal gross;
    private String formattedNet;
    private String formattedVat;
    private String formattedGross;

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

    public String getFormattedNet() {
        return formattedNet;
    }

    public void setFormattedNet(String formattedNet) {
        this.formattedNet = formattedNet;
    }

    public String getFormattedVat() {
        return formattedVat;
    }

    public void setFormattedVat(String formattedVat) {
        this.formattedVat = formattedVat;
    }

    public String getFormattedGross() {
        return formattedGross;
    }

    public void setFormattedGross(String formattedGross) {
        this.formattedGross = formattedGross;
    }
}
