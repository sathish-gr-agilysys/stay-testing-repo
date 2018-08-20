/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

public class RecurringChargesValidityResponse {
    private int chargesIndependentOfReservationDates;
    private int chargesWithInsufficientQuantity;
    private Set<RecurringChargeDetail> chargesWithMaxPerReservationRestriction;
    private Set<RecurringChargeDetail> chargesWithRoomTypeRestriction;
    private int componentChargesWithInsufficientQuantity;
    private int redundantChargesWithComponentItem;

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

    public Set<RecurringChargeDetail> getChargesWithMaxPerReservationRestriction() {
        return chargesWithMaxPerReservationRestriction;
    }

    public void setChargesWithMaxPerReservationRestriction(
          Set<RecurringChargeDetail> chargesWithMaxPerReservationRestriction) {
        this.chargesWithMaxPerReservationRestriction = chargesWithMaxPerReservationRestriction;
    }

    public Set<RecurringChargeDetail> getChargesWithRoomTypeRestriction() {
        return chargesWithRoomTypeRestriction;
    }

    public void setChargesWithRoomTypeRestriction(Set<RecurringChargeDetail> chargesWithRoomTypeRestriction) {
        this.chargesWithRoomTypeRestriction = chargesWithRoomTypeRestriction;
    }

    public int getComponentChargesWithInsufficientQuantity() {
        return componentChargesWithInsufficientQuantity;
    }

    public void setComponentChargesWithInsufficientQuantity(int componentChargesWithInsufficientQuantity) {
        this.componentChargesWithInsufficientQuantity = componentChargesWithInsufficientQuantity;
    }

    public int getRedundantChargesWithComponentItem() {
        return redundantChargesWithComponentItem;
    }

    public void setRedundantChargesWithComponentItem(int redundantChargesWithComponentItem) {
        this.redundantChargesWithComponentItem = redundantChargesWithComponentItem;
    }
}
