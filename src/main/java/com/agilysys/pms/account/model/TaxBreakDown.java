/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class TaxBreakDown {
    private String taxClass;
    private BigDecimal net;
    private BigDecimal vat;
    private BigDecimal gross;

    public TaxBreakDown() {
    }

    public TaxBreakDown(String taxClass, BigDecimal net, BigDecimal vat, BigDecimal gross) {
        this.taxClass = taxClass;
        this.net = net;
        this.vat = vat;
        this.gross = gross;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
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
}
