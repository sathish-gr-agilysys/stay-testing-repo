/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class RecurringChargesValidityRequest {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String roomTypeId;
    private List<ModifyStayDetails> modifyStayDetails;

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

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public List<ModifyStayDetails> getModifyStayDetails() {
        return modifyStayDetails;
    }

    public void setModifyStayDetails(List<ModifyStayDetails> modifyStayDetails) {
        this.modifyStayDetails = modifyStayDetails;
    }
}
