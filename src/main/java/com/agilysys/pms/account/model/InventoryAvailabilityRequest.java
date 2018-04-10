/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.util.Pair;

public class InventoryAvailabilityRequest {
    @JsonProperty(required = true)
    Map<Pair<LocalDate, String>, Integer> itemRequestPerDate;
    boolean validateOverridePermission;

    public Map<Pair<LocalDate, String>, Integer> getItemRequestPerDate() {
        return itemRequestPerDate;
    }

    public void setItemRequestPerDate(Map<Pair<LocalDate, String>, Integer> itemRequestPerDate) {
        this.itemRequestPerDate = itemRequestPerDate;
    }

    public boolean isValidateOverridePermission() {
        return validateOverridePermission;
    }

    public void setValidateOverridePermission(boolean validateOverridePermission) {
        this.validateOverridePermission = validateOverridePermission;
    }
}
