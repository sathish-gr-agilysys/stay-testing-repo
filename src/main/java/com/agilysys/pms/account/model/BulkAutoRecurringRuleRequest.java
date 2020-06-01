/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

public class BulkAutoRecurringRuleRequest {
    private Map<String, Set<String>> roomTypeIdByRatePlanId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int noOfAdults;
    private int noOfChildren;
    private String guestTypeId;
    private String marketSegmentId;

    public Map<String, Set<String>> getRoomTypeIdByRatePlanId() {
        return roomTypeIdByRatePlanId;
    }

    public void setRoomTypeIdByRatePlanId(Map<String, Set<String>> roomTypeIdByRatePlanId) {
        this.roomTypeIdByRatePlanId = roomTypeIdByRatePlanId;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getGuestTypeId() {
        return guestTypeId;
    }

    public void setGuestTypeId(String guestTypeId) {
        this.guestTypeId = guestTypeId;
    }

    public String getMarketSegmentId() {
        return marketSegmentId;
    }

    public void setMarketSegmentId(String marketSegmentId) {
        this.marketSegmentId = marketSegmentId;
    }
}
