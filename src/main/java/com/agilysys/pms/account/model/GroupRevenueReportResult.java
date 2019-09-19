package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public class GroupRevenueReportResult {

    public GroupRevenueReportResult() {}

    public GroupRevenueReportResult(LocalDate date, Map<String, List<GroupRevenueReportItem>> revenueDetails) {
        this.date = date;
        this.revenueDetails = revenueDetails;
    }

    private LocalDate date;

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
