/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class FolioInvoiceReservation {

    private String reservationId;
    private String confirmationCode;
    private String arrivalDate;
    private String departureDate;
    private int totalAdults;
    private int totalChildren;
    private int totalAgeCategory1;
    private int totalAgeCategory2;
    private int totalAgeCategory3;
    private int totalAgeCategory4;
    private int totalAgeCategory5;
    private int totalAgeCategory6;
    private int totalAgeCategory7;
    private int totalAgeCategory8;
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

    public int getTotalAgeCategory1() {
        return totalAgeCategory1;
    }

    public void setTotalAgeCategory1(int totalAgeCategory1) {
        this.totalAgeCategory1 = totalAgeCategory1;
    }

    public int getTotalAgeCategory2() {
        return totalAgeCategory2;
    }

    public void setTotalAgeCategory2(int totalAgeCategory2) {
        this.totalAgeCategory2 = totalAgeCategory2;
    }

    public int getTotalAgeCategory3() {
        return totalAgeCategory3;
    }

    public void setTotalAgeCategory3(int totalAgeCategory3) {
        this.totalAgeCategory3 = totalAgeCategory3;
    }

    public int getTotalAgeCategory4() {
        return totalAgeCategory4;
    }

    public void setTotalAgeCategory4(int totalAgeCategory4) {
        this.totalAgeCategory4 = totalAgeCategory4;
    }

    public int getTotalAgeCategory5() {
        return totalAgeCategory5;
    }

    public void setTotalAgeCategory5(int totalAgeCategory5) {
        this.totalAgeCategory5 = totalAgeCategory5;
    }

    public int getTotalAgeCategory6() {
        return totalAgeCategory6;
    }

    public void setTotalAgeCategory6(int totalAgeCategory6) {
        this.totalAgeCategory6 = totalAgeCategory6;
    }

    public int getTotalAgeCategory7() {
        return totalAgeCategory7;
    }

    public void setTotalAgeCategory7(int totalAgeCategory7) {
        this.totalAgeCategory7 = totalAgeCategory7;
    }

    public int getTotalAgeCategory8() {
        return totalAgeCategory8;
    }

    public void setTotalAgeCategory8(int totalAgeCategory8) {
        this.totalAgeCategory8 = totalAgeCategory8;
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
