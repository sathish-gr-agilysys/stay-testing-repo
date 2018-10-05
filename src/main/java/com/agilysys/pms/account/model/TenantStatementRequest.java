/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

public class TenantStatementRequest {
    private Set<String> companyProfileIds;
    private String invoiceAgingType;

    public TenantStatementRequest() {
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