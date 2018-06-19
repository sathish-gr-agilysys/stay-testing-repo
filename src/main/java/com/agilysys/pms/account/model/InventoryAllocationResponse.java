/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

public class InventoryAllocationResponse {
    private Map<LocalDate, Map<String, Integer>> allocatedCount;

    public Map<LocalDate, Map<String, Integer>> getAllocatedCount() {
        return allocatedCount;
    }

    public void setAllocatedCount(Map<LocalDate, Map<String, Integer>> allocatedCount) {
        this.allocatedCount = allocatedCount;
    }

    public Map<String, Integer> getMaxAllocatedCountForItems() {
        Map<String, Integer> maxAllocatedCountForItemsMap = new HashMap<>();
        for (Entry<LocalDate, Map<String, Integer>> dateEntry : allocatedCount.entrySet()) {
            for (Entry<String, Integer> itemEntry : dateEntry.getValue().entrySet()) {
                Integer count = maxAllocatedCountForItemsMap.get(itemEntry.getKey());
                if (count == null) {
                    count = itemEntry.getValue();
                } else {
                    count = Math.max(count, itemEntry.getValue());
                }
                maxAllocatedCountForItemsMap.put(itemEntry.getKey(), count);
            }
        }
        return maxAllocatedCountForItemsMap;
    }
}
