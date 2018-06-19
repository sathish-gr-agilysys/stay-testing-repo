/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.exceptions.account.AccountErrorCode;

public class RecurringChargeValidityResponse {
    private int numberOfChargesIndependentOfReservationDates;

    //Inventory recurring charges which does not have required quantity for given start and end date
    private int numberOfChargesWithInsufficientQuantity;

    public int getNumberOfChargesIndependentOfReservationDates() {
        return numberOfChargesIndependentOfReservationDates;
    }

    public void setNumberOfChargesIndependentOfReservationDates(int numberOfChargesIndependentOfReservationDates) {
        this.numberOfChargesIndependentOfReservationDates = numberOfChargesIndependentOfReservationDates;
    }

    public int getNumberOfChargesWithInsufficientQuantity() {
        return numberOfChargesWithInsufficientQuantity;
    }

    public void setNumberOfChargesWithInsufficientQuantity(int numberOfChargesWithInsufficientQuantity) {
        this.numberOfChargesWithInsufficientQuantity = numberOfChargesWithInsufficientQuantity;
    }

    public String getMessage() {
        if (numberOfChargesIndependentOfReservationDates > 0 && numberOfChargesWithInsufficientQuantity > 0) {
            return AccountErrorCode.MODIFY_STAY_RECURRING_CHARGE_INVALID_AND_CONFLICTS.internalMessage();
        } else if (numberOfChargesIndependentOfReservationDates > 0) {
            return AccountErrorCode.MODIFY_STAY_RECURRING_CHARGE_INVALID.internalMessage();
        } else if (numberOfChargesWithInsufficientQuantity > 0) {
            return AccountErrorCode.MODIFY_STAY_INVENTORY_CONFLICTS.internalMessage();
        }
        return null;
    }
}
