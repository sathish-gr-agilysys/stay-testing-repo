/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompanyInvoiceBalance {
    private String companyName;
    private List<PropertyInvoiceBalance> propertyInvoiceBalances;
    private BigDecimal[] companyInvoiceTotalsByAging;

    public CompanyInvoiceBalance() {
        propertyInvoiceBalances = new ArrayList<>();
    }

    public CompanyInvoiceBalance(String companyName) {
        this();
        this.companyName = companyName;
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
}