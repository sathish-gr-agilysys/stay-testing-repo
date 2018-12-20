package com.agilysys.pms.account.model;

import java.util.Set;

import org.joda.time.LocalDate;

public class StatsByBuildingRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<String> buildingIds;

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

    public Set<String> getBuildingIds() {
        return buildingIds;
    }

    public void setBuildingIds(Set<String> buildingIds) {
        this.buildingIds = buildingIds;
    }
}
