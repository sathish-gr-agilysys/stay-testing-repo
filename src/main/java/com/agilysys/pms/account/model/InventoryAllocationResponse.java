/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

import org.joda.time.LocalDate;

public class InventoryAllocationResponse {
    private Map<LocalDate, Map<String, Integer>> allocatedCount;

    public Map<LocalDate, Map<String, Integer>> getAllocatedCount() {
        return allocatedCount;
    }

    public void setAllocatedCount(Map<LocalDate, Map<String, Integer>> allocatedCount) {
        this.allocatedCount = allocatedCount;
    }
}
