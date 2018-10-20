/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropertyInvoiceBalance {

    private String propertyName;
    private BigDecimal total;
    private List<InvoiceBalanceResponse> invoiceBalanceResponses;
    private List<BigDecimal> accountInvoiceTotalsByAging;

    public PropertyInvoiceBalance() {
        this.invoiceBalanceResponses = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public PropertyInvoiceBalance(String propertyName) {
        this();
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<InvoiceBalanceResponse> getInvoiceBalanceResponses() {
        return invoiceBalanceResponses;
    }

    public void setInvoiceBalanceResponses(List<InvoiceBalanceResponse> invoiceBalanceResponses) {
        this.invoiceBalanceResponses = invoiceBalanceResponses;
    }

    public List<BigDecimal> getAccountInvoiceTotalsByAging() {
        return accountInvoiceTotalsByAging;
    }

    public void setAccountInvoiceTotalsByAging(List<BigDecimal> accountInvoiceTotalsByAging) {
        this.accountInvoiceTotalsByAging = accountInvoiceTotalsByAging;
    }
}