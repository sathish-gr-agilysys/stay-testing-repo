/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
This request class can be used to get the allocation count of inventory item on a specific date
 */
public class CheckInventoryAllocation {

    /*Inventory items allocation request has request for different dates and different inventory items,
    it is grouped as Map of Map, holds the request for different dates in which inventory items are going to create,
    key is start date of inventory item and value is map and whose key is end date of inventory item
    and its value is list of InventoryAllocationRequest*/
    @JsonProperty(required = true)
    private Map<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> inventoryAllocationRequests;

    public Map<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> getInventoryAllocationRequests() {
        return inventoryAllocationRequests;
    }

    public void setInventoryAllocationRequests(
          Map<LocalDate, Map<LocalDate, List<InventoryAllocationRequest>>> inventoryAllocationRequests) {
        this.inventoryAllocationRequests = inventoryAllocationRequests;
    }

    @JsonIgnore
    public Set<String> getInventoryItemIds() {
        return inventoryAllocationRequests.values().stream().map(Map::values).flatMap(Collection::stream)
              .flatMap(Collection::stream).map(InventoryAllocationRequest::getInventoryItemId)
              .collect(Collectors.toSet());
    }
}
