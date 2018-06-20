/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.exceptions.account.AccountErrorCode;

public class RecurringChargeValidityResponse {
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

    public String getMessage() {
        if (chargesIndependentOfReservationDates > 0 && chargesWithInsufficientQuantity > 0) {
            return AccountErrorCode.MODIFY_STAY_RECURRING_CHARGE_INVALID_AND_CONFLICTS.internalMessage();
        }

        if (chargesIndependentOfReservationDates > 0) {
            return AccountErrorCode.MODIFY_STAY_RECURRING_CHARGE_INVALID.internalMessage();
        }

        if (chargesWithInsufficientQuantity > 0) {
            return AccountErrorCode.MODIFY_STAY_INVENTORY_CONFLICTS.internalMessage();
        }

        return null;
    }
}
