/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.json.serialize.LocalDateJsonKeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class RevenueReportResult {
    @JsonDeserialize(keyUsing = LocalDateJsonKeyDeserializer.class)
    private Map<LocalDate, List<RevenueReportItem>> revenueDetails;

    public RevenueReportResult() {}

    public RevenueReportResult(Map<LocalDate, List<RevenueReportItem>> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }

    public Map<LocalDate, List<RevenueReportItem>> getRevenueDetails() {
        return revenueDetails;
    }

    public void setRevenueDetails(Map<LocalDate, List<RevenueReportItem>> revenueDetails) {
        this.revenueDetails = revenueDetails;
    }
}
