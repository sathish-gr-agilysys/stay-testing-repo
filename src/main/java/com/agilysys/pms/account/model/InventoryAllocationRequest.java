/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static com.agilysys.pms.common.exceptions.ExceptionFactory.accountException;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTimeConstants;

import com.agilysys.platform.common.json.schema.MinValueRestriction;
import com.agilysys.pms.common.exceptions.account.AccountErrorCode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryAllocationRequest {
    @JsonProperty(required = true)
    private FrequencyType frequencyType;
    @MinValueRestriction(1)
    private int nNights;
    // Convention per ISO standard DateTimeConstants in org.joda.time; Monday 1 .... Sunday 7
    private Set<Integer> occurrenceDays;
    @JsonProperty(required = true)
    private String inventoryItemId;

    public InventoryAllocationRequest() {
        occurrenceDays = new HashSet<>();
    }

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
        if (occurrenceDays != null) {
            if (occurrenceDays.stream()
                  .anyMatch(day -> day < DateTimeConstants.MONDAY || day > DateTimeConstants.SUNDAY)) {
                throw accountException(AccountErrorCode.OCCURRENCE_DAYS_INVALID).buildCompatible();
            }
        }
        this.occurrenceDays = occurrenceDays;
    }
}
