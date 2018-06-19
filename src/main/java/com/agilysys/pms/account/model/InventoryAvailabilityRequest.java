/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryAvailabilityRequest {
    @JsonProperty(required = true)
    Map<LocalDate, Map<String, Integer>> itemRequestPerDate;
    boolean validateOverridePermission;

    public Map<LocalDate, Map<String, Integer>> getItemRequestPerDate() {
        return itemRequestPerDate;
    }

    public void setItemRequestPerDate(Map<LocalDate, Map<String, Integer>> itemRequestPerDate) {
        this.itemRequestPerDate = itemRequestPerDate;
    }

    public boolean isValidateOverridePermission() {
        return validateOverridePermission;
    }

    public void setValidateOverridePermission(boolean validateOverridePermission) {
        this.validateOverridePermission = validateOverridePermission;
    }
}
