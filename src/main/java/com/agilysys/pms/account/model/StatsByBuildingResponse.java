package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;

import com.agilysys.pms.common.model.GeneralAvailabilityResult;

public class StatsByBuildingResponse {
    private Map<String, GeneralAvailabilityResult> generalAvailabilityByBuilding;

    public Map<String, GeneralAvailabilityResult> getGeneralAvailabilityByBuilding() {
        return generalAvailabilityByBuilding;
    }

    public void setGeneralAvailabilityByBuilding(Map<String, GeneralAvailabilityResult> generalAvailabilityByBuilding) {
        this.generalAvailabilityByBuilding = generalAvailabilityByBuilding;
    }

    public StatsByBuildingResponse() {
        this.generalAvailabilityByBuilding = new HashMap<>();
    }
}
