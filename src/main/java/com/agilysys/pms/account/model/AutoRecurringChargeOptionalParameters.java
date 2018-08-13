/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AutoRecurringChargeOptionalParameters {
    private boolean applyAmountToAutoRecurringItems;
    private boolean applyStatusToAutoRecurringItems;
    private boolean applyToFutureReservations;
    private boolean applyToInHouseReservations;

    public boolean isApplyStatusToAutoRecurringItems() {
        return applyStatusToAutoRecurringItems;
    }

    public void setApplyStatusToAutoRecurringItems(boolean applyStatusToAutoRecurringItems) {
        this.applyStatusToAutoRecurringItems = applyStatusToAutoRecurringItems;
    }

    public boolean isApplyAmountToAutoRecurringItems() {
        return applyAmountToAutoRecurringItems;
    }

    public void setApplyAmountToAutoRecurringItems(boolean applyAmountToAutoRecurringItems) {
        this.applyAmountToAutoRecurringItems = applyAmountToAutoRecurringItems;
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
