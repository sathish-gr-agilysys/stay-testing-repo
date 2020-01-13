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

    private int ageCategory1;
    private int ageCategory2;
    private int ageCategory3;
    private int ageCategory4;
    private int ageCategory5;
    private int ageCategory6;
    private int ageCategory7;
    private int ageCategory8;

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

    public int getAgeCategory1() {
        return ageCategory1;
    }

    public void setAgeCategory1(int ageCategory1) {
        this.ageCategory1 = ageCategory1;
    }

    public int getAgeCategory2() {
        return ageCategory2;
    }

    public void setAgeCategory2(int ageCategory2) {
        this.ageCategory2 = ageCategory2;
    }

    public int getAgeCategory3() {
        return ageCategory3;
    }

    public void setAgeCategory3(int ageCategory3) {
        this.ageCategory3 = ageCategory3;
    }

    public int getAgeCategory4() {
        return ageCategory4;
    }

    public void setAgeCategory4(int ageCategory4) {
        this.ageCategory4 = ageCategory4;
    }

    public int getAgeCategory5() {
        return ageCategory5;
    }

    public void setAgeCategory5(int ageCategory5) {
        this.ageCategory5 = ageCategory5;
    }

    public int getAgeCategory6() {
        return ageCategory6;
    }

    public void setAgeCategory6(int ageCategory6) {
        this.ageCategory6 = ageCategory6;
    }

    public int getAgeCategory7() {
        return ageCategory7;
    }

    public void setAgeCategory7(int ageCategory7) {
        this.ageCategory7 = ageCategory7;
    }

    public int getAgeCategory8() {
        return ageCategory8;
    }

    public void setAgeCategory8(int ageCategory8) {
        this.ageCategory8 = ageCategory8;
    }
}
