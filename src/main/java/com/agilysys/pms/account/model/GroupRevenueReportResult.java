package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GroupRevenueReportResult {

    public GroupRevenueReportResult() {}

    public GroupRevenueReportResult(Map<String, List<GroupRevenueReportItem>> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }

    private LocalDate date;

    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    private Map<String, List<GroupRevenueReportItem>> revenueDetails;

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, List<GroupRevenueReportItem>> getRevenueDetails() {
        return revenueDetails;
    }

    public void setRevenueDetails(Map<String, List<GroupRevenueReportItem>> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }
}
