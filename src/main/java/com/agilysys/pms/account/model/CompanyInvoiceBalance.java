/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompanyInvoiceBalance {
    private String companyName;
    private BigDecimal accountBalance;
    private BigDecimal total;
    private List<PropertyInvoiceBalance> propertyInvoiceBalances;
    private BigDecimal[] companyInvoiceTotalsByAging;

    public CompanyInvoiceBalance() {
        accountBalance = BigDecimal.ZERO;
        propertyInvoiceBalances = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    public CompanyInvoiceBalance(String companyName) {
        this();
        this.companyName = companyName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<PropertyInvoiceBalance> getPropertyInvoiceBalances() {
        return propertyInvoiceBalances;
    }

    public void setPropertyInvoiceBalances(List<PropertyInvoiceBalance> propertyInvoiceBalances) {
        this.propertyInvoiceBalances = propertyInvoiceBalances;
    }

    public BigDecimal[] getCompanyInvoiceTotalsByAging() {
        return companyInvoiceTotalsByAging;
    }

    public void setCompanyInvoiceTotalsByAging(BigDecimal[] companyInvoiceTotalsByAging) {
        this.companyInvoiceTotalsByAging = companyInvoiceTotalsByAging;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}