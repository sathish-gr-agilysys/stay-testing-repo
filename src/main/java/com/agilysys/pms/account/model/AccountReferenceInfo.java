/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class AccountReferenceInfo {

    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String name;

    private String reservationId;

    public AccountReferenceInfo() {

    }

    public AccountReferenceInfo(String sourceName, LocalDate arrivalDate, LocalDate departureDate,
          String reservationId) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.name = sourceName;
        this.reservationId = reservationId;
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

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
