/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class AccountReferenceInfo {

    private String name;
    private LocalDate arrivalDate;
    private LocalDate departureDate;

    public AccountReferenceInfo(String sourceName, LocalDate arrivalDate, LocalDate departureDate) {
        this.name = sourceName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
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
}
