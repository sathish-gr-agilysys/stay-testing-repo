/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class TenantStatementResponse {
    private List<String> ageGroupLabels;
    private List<CompanyInvoiceBalance> companyInvoiceBalances;

    public TenantStatementResponse() {
        companyInvoiceBalances = new ArrayList<>();
    }

    public TenantStatementResponse(List<String> ageGroupLabels) {
        this();
        this.ageGroupLabels = ageGroupLabels;
    }

    public List<CompanyInvoiceBalance> getCompanyInvoiceBalances() {
        return companyInvoiceBalances;
    }

    public List<String> getAgeGroupLabels() {
        return ageGroupLabels;
    }
}