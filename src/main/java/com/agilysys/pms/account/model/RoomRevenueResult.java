/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

public class RoomRevenueResult {
    private Map<String, RoomRevenueItem> revenueMap;

    public Map<String, RoomRevenueItem> getRevenueMap() {
        return revenueMap;
    }

    public void setRevenueMap(Map<String, RoomRevenueItem> revenueMap) {
        this.revenueMap = revenueMap;
    }
}
