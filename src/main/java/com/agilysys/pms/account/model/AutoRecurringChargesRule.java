/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Set;

public class AutoRecurringChargesRule {

    private String id;
    private String tenantId;
    private String propertyId;
    private String ruleName;
    private String ruleCode;
    private boolean active;
    private String description;
    private List<AutoRecurringItem> items;
    private Set<String> ratePlans;
    private Set<String> packages;
    private Set<String> roomTypes;
    private Set<String> buildings;
    private Set<String> guestTypes;
    private Set<String> marketSegments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AutoRecurringItem> getItems() {
        return items;
    }

    public void setItems(List<AutoRecurringItem> items) {
        this.items = items;
    }

    public Set<String> getRatePlans() {
        return ratePlans;
    }

    public void setRatePlans(Set<String> ratePlans) {
        this.ratePlans = ratePlans;
    }

    public Set<String> getPackages() {
        return packages;
    }

    public void setPackages(Set<String> packages) {
        this.packages = packages;
    }

    public Set<String> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(Set<String> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public Set<String> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<String> buildings) {
        this.buildings = buildings;
    }

    public Set<String> getGuestTypes() {
        return guestTypes;
    }

    public void setGuestTypes(Set<String> guestTypes) {
        this.guestTypes = guestTypes;
    }

    public Set<String> getMarketSegments() {
        return marketSegments;
    }

    public void setMarketSegments(Set<String> marketSegments) {
        this.marketSegments = marketSegments;
    }
}
