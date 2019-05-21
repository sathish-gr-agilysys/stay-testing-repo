/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class FolioInvoiceReservationLoyaltyInfo {

    private String reservationLoyaltyId;
    private String reservationLoyaltyProgram;
    private String reservationLoyaltyMemberId;
    private boolean reservationLoyaltyDefault;
    private String reservationLoyaltyComments;

    public String getReservationLoyaltyId() {
        return reservationLoyaltyId;
    }

    public void setReservationLoyaltyId(String reservationLoyaltyId) {
        this.reservationLoyaltyId = reservationLoyaltyId;
    }

    public String getReservationLoyaltyProgram() {
        return reservationLoyaltyProgram;
    }

    public void setReservationLoyaltyProgram(String reservationLoyaltyProgram) {
        this.reservationLoyaltyProgram = reservationLoyaltyProgram;
    }

    public String getReservationLoyaltyMemberId() {
        return reservationLoyaltyMemberId;
    }

    public void setReservationLoyaltyMemberId(String reservationLoyaltyMemberId) {
        this.reservationLoyaltyMemberId = reservationLoyaltyMemberId;
    }

    public boolean getReservationLoyaltyDefault() {
        return reservationLoyaltyDefault;
    }

    public void setReservationLoyaltyDefault(boolean reservationLoyaltyDefault) {
        this.reservationLoyaltyDefault = reservationLoyaltyDefault;
    }

    public String getReservationLoyaltyComments() {
        return reservationLoyaltyComments;
    }

    public void setReservationLoyaltyComments(String reservationLoyaltyComments) {
        this.reservationLoyaltyComments = reservationLoyaltyComments;
    }
}
