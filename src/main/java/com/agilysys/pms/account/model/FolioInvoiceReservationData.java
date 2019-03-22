/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class FolioInvoiceReservationData {

    private String reservationId;
    private String confirmationCode;
    private String arrivalDate;
    private String departureDate;
    private int totalAdults;
    private int totalChildren;
    private String allocationId;
    private boolean reservationAliasEnabled;
    private String reservationAlias;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getTotalAdults() {
        return totalAdults;
    }

    public void setTotalAdults(int totalAdults) {
        this.totalAdults = totalAdults;
    }

    public int getTotalChildren() {
        return totalChildren;
    }

    public void setTotalChildren(int totalChildren) {
        this.totalChildren = totalChildren;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public boolean isReservationAliasEnabled() {
        return reservationAliasEnabled;
    }

    public void setReservationAliasEnabled(boolean reservationAliasEnabled) {
        this.reservationAliasEnabled = reservationAliasEnabled;
    }

    public String getReservationAlias() {
        return reservationAlias;
    }

    public void setReservationAlias(String reservationAlias) {
        this.reservationAlias = reservationAlias;
    }
}
