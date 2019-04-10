/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.pms.common.model.export.ExportMapSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TaxExemptSettingsExport {
    private String taxId;
    @JsonSerialize(using = ExportMapSerializer.class)
    private Map<LocalDate, Set<String>> exemptionsByDate;
    private List<String> exemptions;

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Map<LocalDate, Set<String>> getExemptionsByDate() {
        return exemptionsByDate;
    }

    public void setExemptionsByDate(Map<LocalDate, Set<String>> exemptionsByDate) {
        this.exemptionsByDate = exemptionsByDate;
    }

    public List<String> getExemptions() {
        return exemptions;
    }

    public void setExemptions(List<String> exemptions) {
        this.exemptions = exemptions;
    }
}