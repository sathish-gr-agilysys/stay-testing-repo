package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TaxExemptReportItem {

    private AccountSummary accountInfo;
    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    private Map<LocalDate, List<String>> taxExemptions;

    public AccountSummary getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountSummary accountInfo) {
        this.accountInfo = accountInfo;
    }

    public Map<LocalDate, List<String>> getTaxExemptions() {
        return taxExemptions;
    }

    public void setTaxExemptions(Map<LocalDate, List<String>> taxExemptions) {
        this.taxExemptions = taxExemptions;
    }
}
