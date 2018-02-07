/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Sets;

public class CheckInventoryAllocation {
    @JsonProperty(required = true)
    private Map<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> inventoryAllocationRequests;
    private Set<String> excludeAccounts = Sets.newHashSet();

    public Set<String> getExcludeAccounts() {
        return excludeAccounts;
    }

    public void setExcludeAccounts(Set<String> excludeAccounts) {
        this.excludeAccounts = excludeAccounts;
    }

    public Map<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> getInventoryAllocationRequests() {
        return inventoryAllocationRequests;
    }

    public void setInventoryAllocationRequests(
          Map<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> inventoryAllocationRequests) {
        this.inventoryAllocationRequests = inventoryAllocationRequests;
    }

    @JsonIgnore
    public Set<String> getInventoryItemIds() {
        HashSet<String> itemIds = new HashSet<>();
        for (Map.Entry<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> startDateEntry :
              inventoryAllocationRequests
              .entrySet()) {
            for (Map.Entry<LocalDate, List<InventoryAllocationRequest>> endDateEntry : startDateEntry.getValue()
                  .entrySet()) {
                for (InventoryAllocationRequest inventoryAllocationRequest : endDateEntry.getValue())
                    itemIds.add(inventoryAllocationRequest.getInventoryItemId());
            }
        }
        return itemIds;
    }
}
