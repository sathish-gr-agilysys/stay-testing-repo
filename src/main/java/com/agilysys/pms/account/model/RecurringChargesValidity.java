/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class RecurringChargesValidity {
    private int chargesIndependentOfReservationDates;

    //Inventory recurring charges which does not have required quantity for given start and end date
    private int chargesWithInsufficientQuantity;

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
}
