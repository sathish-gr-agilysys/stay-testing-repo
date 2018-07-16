/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class RecurringChargesValidity {
    private int chargesIndependentOfReservationDates;
    private int chargesWithInsufficientQuantity;
    private int chargesWithMaxPerReservationRestriction;
    private int chargesWithRoomTypeRestriction;

    public int getChargesIndependentOfReservationDates() {
        return chargesIndependentOfReservationDates;
    }

    public void setChargesIndependentOfReservationDates(int chargesIndependentOfReservationDates) {
        this.chargesIndependentOfReservationDates = chargesIndependentOfReservationDates;
    }

    public int getChargesWithInsufficientQuantity() {
        return chargesWithInsufficientQuantity;
    }

    public void setChargesWithInsufficientQuantity(int chargesWithInsufficientQuantity) {
        this.chargesWithInsufficientQuantity = chargesWithInsufficientQuantity;
    }

    public int getChargesWithMaxPerReservationRestriction() {
        return chargesWithMaxPerReservationRestriction;
    }

    public void setChargesWithMaxPerReservationRestriction(int chargesWithMaxPerReservationRestriction) {
        this.chargesWithMaxPerReservationRestriction = chargesWithMaxPerReservationRestriction;
    }

    public int getChargesWithRoomTypeRestriction() {
        return chargesWithRoomTypeRestriction;
    }

    public void setChargesWithRoomTypeRestriction(int chargesWithRoomTypeRestriction) {
        this.chargesWithRoomTypeRestriction = chargesWithRoomTypeRestriction;
    }
}
