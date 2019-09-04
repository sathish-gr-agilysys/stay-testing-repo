package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GroupRevenueReportResult {

    public  GroupRevenueReportResult() {}

    public  GroupRevenueReportResult(Map<String, List<RevenueReportItem>> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }

    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    private Map<String, List<RevenueReportItem>> revenueDetails;

    public Map<String, List<RevenueReportItem>> getRevenueDetails() {
        return revenueDetails;
    }

    public void setRevenueDetails(Map<String, List<RevenueReportItem>> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }
}
