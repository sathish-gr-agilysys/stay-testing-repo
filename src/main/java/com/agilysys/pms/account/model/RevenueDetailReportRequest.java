/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

import org.joda.time.LocalDate;

public class RevenueDetailReportRequest {
    private Set<String> buildingIds;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean roomRevenue;

    public RevenueDetailReportRequest() {
    }

    public RevenueDetailReportRequest(Set<String> buildingIds, LocalDate startDate, LocalDate endDate, boolean roomRevenue) {
        this.buildingIds = buildingIds;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomRevenue = roomRevenue;
    }

    public Set<String> getBuildingIds() {
        return buildingIds;
    }

    public void setBuildingIds(Set<String> buildingIds) {
        this.buildingIds = buildingIds;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isRoomRevenue() {
        return roomRevenue;
    }

    public void setRoomRevenue(boolean roomRevenue) {
        this.roomRevenue = roomRevenue;
    }
}
