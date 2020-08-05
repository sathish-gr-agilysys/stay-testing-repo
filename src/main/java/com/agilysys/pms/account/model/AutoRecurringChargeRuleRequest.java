/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class AutoRecurringChargeRuleRequest {
    private Integer noOfAdults;
    private Integer noOfChildren;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guestTypeId;
    private String marketSegmentId;
    private String arrivalDateRatePlanId;
    private String arrivalDateRoomTypeId;
    private String roomId;
    private String groupId;

    public AutoRecurringChargeRuleRequest() {}

    public AutoRecurringChargeRuleRequest(int noOfAdults, int noOfChildren, LocalDate arrivalDate,
          LocalDate departureDate, String guestTypeId, String marketSegmentId, String arrivalDateRatePlanId,
          String arrivalDateRoomTypeId, String roomId, String groupId) {
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guestTypeId = guestTypeId;
        this.marketSegmentId = marketSegmentId;
        this.arrivalDateRatePlanId = arrivalDateRatePlanId;
        this.arrivalDateRoomTypeId = arrivalDateRoomTypeId;
        this.roomId = roomId;
        this.groupId = groupId;
    }

    public Integer getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(Integer noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public Integer getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(Integer noOfChildren) {
        this.noOfChildren = noOfChildren;
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

    public String getArrivalDateRatePlanId() {
        return arrivalDateRatePlanId;
    }

    public void setArrivalDateRatePlanId(String arrivalDateRatePlanId) {
        this.arrivalDateRatePlanId = arrivalDateRatePlanId;
    }

    public String getArrivalDateRoomTypeId() {
        return arrivalDateRoomTypeId;
    }

    public void setArrivalDateRoomTypeId(String arrivalDateRoomTypeId) {
        this.arrivalDateRoomTypeId = arrivalDateRoomTypeId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}

