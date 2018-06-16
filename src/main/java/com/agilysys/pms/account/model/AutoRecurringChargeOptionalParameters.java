/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AutoRecurringChargeOptionalParameters {
    //This field is used when transaction item is updated, user wants to update the ARC's as well
    private boolean applyToAutoRecurringItems;
    private boolean applyToFutureReservations;
    private boolean applyToInHouseReservations;

    public boolean isApplyToAutoRecurringItems() {
        return applyToAutoRecurringItems;
    }

    public void setApplyToAutoRecurringItems(boolean applyToAutoRecurringItems) {
        this.applyToAutoRecurringItems = applyToAutoRecurringItems;
    }

    public boolean isApplyToFutureReservations() {
        return applyToFutureReservations;
    }

    public void setApplyToFutureReservations(boolean applyToFutureReservations) {
        this.applyToFutureReservations = applyToFutureReservations;
    }

    public boolean isApplyToInHouseReservations() {
        return applyToInHouseReservations;
    }

    public void setApplyToInHouseReservations(boolean applyToInHouseReservations) {
        this.applyToInHouseReservations = applyToInHouseReservations;
    }
}
