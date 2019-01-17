package com.agilysys.pms.account.model;

import java.util.Set;

import org.joda.time.LocalDate;

public class StatsByBuildingRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<String> buildingIds;
    private boolean byBuilding;
    private boolean includeNonBeddedRoomType;

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

    public boolean isByBuilding() {
        return byBuilding;
    }

    public void setByBuilding(boolean byBuilding) {
        this.byBuilding = byBuilding;
    }

    public boolean isIncludeNonBeddedRoomType() {
        return includeNonBeddedRoomType;
    }

    public void setIncludeNonBeddedRoomType(boolean includeNonBeddedRoomType) {
        this.includeNonBeddedRoomType = includeNonBeddedRoomType;
    }
}
