package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TaxExemptReportItem {
    private String referenceId;
    private String taxId;

    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    private Map<LocalDate, Map<String, BigDecimal>> taxExemptions;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Map<LocalDate, Map<String, BigDecimal>> getTaxExemptions() {
        return taxExemptions;
    }

    public void setTaxExemptions(Map<LocalDate, Map<String, BigDecimal>> taxExemptions) {
        this.taxExemptions = taxExemptions;
    }
}
