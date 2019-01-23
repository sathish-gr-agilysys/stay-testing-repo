package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.GeneralAvailabilityResult;
import com.agilysys.pms.property.model.RoomMetrics;

public class GeneralAvailabilityStatsResult extends GeneralAvailabilityResult {
    private String buildingId;
    private boolean byBuilding;
    private boolean includeNonBeddedRoomType;
    private RoomMetrics roomMetrics;

    public GeneralAvailabilityStatsResult(GeneralAvailabilityResult generalAvailabilityResult) {
        super(generalAvailabilityResult);
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
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

    public RoomMetrics getRoomMetrics() {
        return roomMetrics;
    }

    public void setRoomMetrics(RoomMetrics roomMetrics) {
        this.roomMetrics = roomMetrics;
    }
}
