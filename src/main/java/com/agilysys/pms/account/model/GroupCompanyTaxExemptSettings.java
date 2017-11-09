/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Tax exempt settings for a group or company account
 */
public class GroupCompanyTaxExemptSettings extends TaxExemptSettings {
    @JsonIgnore
    private LocalDate createdPropertyDate;
    private List<String> exemptions;
    @JsonIgnore
    private Map<LocalDate, List<String>> history;
    private Map<LocalDate, List<String>> exemptionsByDate;

    public LocalDate getCreatedPropertyDate() {
        return createdPropertyDate;
    }

    public void setCreatedPropertyDate(LocalDate createdPropertyDate) {
        this.createdPropertyDate = createdPropertyDate;
    }

    public List<String> getExemptions() {
        return this.exemptions;
    }

    public void setExemptions(List<String> exemptions) {
        this.exemptions = exemptions;
    }

    public Map<LocalDate, List<String>> getHistory() {
        return history;
    }

    public void setHistory(Map<LocalDate, List<String>> history) {
        this.history = history;
    }


    public Map<LocalDate, List<String>> getExemptionsByDate() {
        return exemptionsByDate;
    }

    public void setExemptionsByDate(Map<LocalDate, List<String>> exemptionsByDate) {
        this.exemptionsByDate = exemptionsByDate;
    }

}