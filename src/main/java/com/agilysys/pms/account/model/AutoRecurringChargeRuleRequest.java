package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class AutoRecurringChargeRuleRequest {
    private int noOfAdults;
    private int noOfChildren;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String guestTypeId;
    private String marketSegmentId;
    private String arrivalDateRatePlanId;
    private String arrivalDateRoomTypeId;
    private String groupId;

    public AutoRecurringChargeRuleRequest() {}

    public AutoRecurringChargeRuleRequest(int noOfAdults, int noOfChildren, LocalDate arrivalDate,
          LocalDate departureDate, String guestTypeId, String marketSegmentId, String arrivalDateRatePlanId,
          String arrivalDateRoomTypeId) {
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guestTypeId = guestTypeId;
        this.marketSegmentId = marketSegmentId;
        this.arrivalDateRatePlanId = arrivalDateRatePlanId;
        this.arrivalDateRoomTypeId = arrivalDateRoomTypeId;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}

