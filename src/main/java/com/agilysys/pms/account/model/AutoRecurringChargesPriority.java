/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AutoRecurringChargesPriority {
    private String tenantId;
    private String propertyId;
    private int ratePlans;
    private int packages;
    private int roomTypes;
    private int buildings;
    private int guestTypes;
    private int marketSegments;

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

    public int getRatePlans() {
        return ratePlans;
    }

    public void setRatePlans(int ratePlans) {
        this.ratePlans = ratePlans;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public int getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(int roomTypes) {
        this.roomTypes = roomTypes;
    }

    public int getBuildings() {
        return buildings;
    }

    public void setBuildings(int buildings) {
        this.buildings = buildings;
    }

    public int getGuestTypes() {
        return guestTypes;
    }

    public void setGuestTypes(int guestTypes) {
        this.guestTypes = guestTypes;
    }

    public int getMarketSegments() {
        return marketSegments;
    }

    public void setMarketSegments(int marketSegments) {
        this.marketSegments = marketSegments;
    }
}
