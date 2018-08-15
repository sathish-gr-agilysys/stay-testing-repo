/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModifyStayComponentRequest {

    @JsonProperty(required = true)
    private String componentBundleId;
    @JsonProperty(required = true)
    private LocalDate startDate;
    @JsonProperty(required = true)
    private LocalDate endDate;

    public ModifyStayComponentRequest() {}

    public ModifyStayComponentRequest(String componentBundleId, LocalDate startDate, LocalDate endDate) {
        this.componentBundleId = componentBundleId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getComponentBundleId() {
        return componentBundleId;
    }

    public void setComponentBundleId(String componentBundleId) {
        this.componentBundleId = componentBundleId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
