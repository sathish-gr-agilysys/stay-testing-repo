/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class FolioInvoiceTaxSummary {
    private List<String> fieldNames;
    private List<FolioTaxBreakDown> taxBreakDowns;
    private List<BreakDown> totalBreakDowns;

    public FolioInvoiceTaxSummary() {
    }

    public FolioInvoiceTaxSummary(List<String> fieldNames, List<FolioTaxBreakDown> taxBreakDowns,
          List<BreakDown> totalBreakDowns) {
        this.fieldNames = fieldNames;
        this.taxBreakDowns = taxBreakDowns;
        this.totalBreakDowns = totalBreakDowns;
    }

    public List<String> getFieldNames() { return fieldNames; }

    public void setFieldNames(List<String> fieldNames) { this.fieldNames = fieldNames; }

    public List<FolioTaxBreakDown> getTaxBreakDowns() {
        return taxBreakDowns;
    }

    public void setTaxBreakDowns(List<FolioTaxBreakDown> taxBreakDowns) {
        this.taxBreakDowns = taxBreakDowns;
    }

    public List<BreakDown> getTotalBreakDowns() {
        return totalBreakDowns;
    }

    public void setTotalBreakDowns(List<BreakDown> totalBreakDowns) {
        this.totalBreakDowns = totalBreakDowns;
    }
}
