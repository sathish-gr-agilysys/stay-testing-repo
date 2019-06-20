/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

import com.agilysys.pms.rates.model.ComponentBundle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ModifyStayDetails {
    @JsonProperty(required = true)
    private String ratePlanId;

    @Deprecated
    private String componentBundleId;

    private ComponentBundle componentBundle;

    @JsonProperty(required = true)
    private LocalDate startDate;

    @JsonProperty(required = true)
    private LocalDate endDate;

    private int adults;

    private int children;

    public ModifyStayDetails() {}

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getComponentBundleId() {
        return componentBundleId;
    }

    public void setComponentBundleId(String componentBundleId) {
        this.componentBundleId = componentBundleId;
    }

    public ComponentBundle getComponentBundle() {
        return componentBundle;
    }

    public void setComponentBundle(ComponentBundle componentBundle) {
        this.componentBundle = componentBundle;
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

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
