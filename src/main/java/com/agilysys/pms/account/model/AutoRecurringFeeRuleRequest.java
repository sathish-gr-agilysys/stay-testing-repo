/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

import org.joda.time.LocalDate;

public class AutoRecurringFeeRuleRequest {
    private Integer noOfAdults;
    private Integer noOfChildren;
    private String guestTypeId;
    private String marketSegmentId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private Map<LocalDate, String> perDayRatePlanId;
    private Map<LocalDate, String> perDayRoomTypeId;

    public AutoRecurringFeeRuleRequest() {}

    public AutoRecurringFeeRuleRequest(Integer noOfAdults, Integer noOfChildren, String guestTypeId,
          String marketSegmentId, LocalDate arrivalDate, LocalDate departureDate) {
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.guestTypeId = guestTypeId;
        this.marketSegmentId = marketSegmentId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
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

    public Map<LocalDate, String> getPerDayRatePlanId() {
        return perDayRatePlanId;
    }

    public void setPerDayRatePlanId(Map<LocalDate, String> perDayRatePlanId) {
        this.perDayRatePlanId = perDayRatePlanId;
    }

    public Map<LocalDate, String> getPerDayRoomTypeId() {
        return perDayRoomTypeId;
    }

    public void setPerDayRoomTypeId(Map<LocalDate, String> perDayRoomTypeId) {
        this.perDayRoomTypeId = perDayRoomTypeId;
    }
}

