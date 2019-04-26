/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

public class TenantStatementRequest {
    private static final String DEFAULT_INVOICE_AGING_TYPE = "AGE_BY_PROPERTY_DATE";
    private Set<String> companyProfileIds;
    private String invoiceAgingType;

    public TenantStatementRequest() {
        invoiceAgingType = DEFAULT_INVOICE_AGING_TYPE;
    }

    public Set<String> getCompanyProfileIds() {
        return companyProfileIds;
    }

    public void setCompanyProfileIds(Set<String> companyProfileIds) {
        this.companyProfileIds = companyProfileIds;
    }

    public String getInvoiceAgingType() {
        return invoiceAgingType;
    }

    public void setInvoiceAgingType(String invoiceAgingType) {
        this.invoiceAgingType = invoiceAgingType;
    }
}