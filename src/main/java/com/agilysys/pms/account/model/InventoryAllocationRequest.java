/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashSet;
import java.util.Set;

import com.agilysys.platform.common.json.schema.MinValueRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryAllocationRequest {
    @JsonProperty(required = true)
    private FrequencyType frequencyType;
    @MinValueRestriction(1)
    private int nNights;
    private Set<Integer> occurrenceDays = new HashSet<>();
    @JsonProperty(required = true)
    private String inventoryItemId;

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public int getnNights() {
        return nNights;
    }

    public void setnNights(int nNights) {
        this.nNights = nNights;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
    }

    public Set<Integer> getOccurrenceDays() {
        return occurrenceDays;
    }

    public void setOccurrenceDays(Set<Integer> occurrenceDays) {
        this.occurrenceDays = occurrenceDays;
    }
}
