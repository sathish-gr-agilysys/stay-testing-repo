package com.agilysys.pms.account.model;

import java.util.Set;

import org.joda.time.LocalDate;

public class RevenueDetailReportRequest {
    private Set<String> buildingId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isRoomRevenue;

    public Set<String> getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Set<String> buildingId) {
        this.buildingId = buildingId;
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
        return isRoomRevenue;
    }

    public void setIsRoomRevenue(boolean isRoomRevenue) {
        this.isRoomRevenue = isRoomRevenue;
    }
}
