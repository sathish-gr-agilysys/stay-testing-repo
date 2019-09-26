/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class RecurringChargesPostingResult {
    private List<RecurringChargePostingError> errors = new ArrayList<>();
    private List<RecurringChargeView> recurringCharges = new ArrayList<>();
    private List<RecurringChargeView> roomCharges = new ArrayList<>();

    public List<RecurringChargePostingError> getErrors() {
        return errors;
    }

    public void setErrors(List<RecurringChargePostingError> errors) {
        this.errors = errors;
    }

    public List<RecurringChargeView> getRecurringCharges() {
        return recurringCharges;
    }

    public void setRecurringCharges(List<RecurringChargeView> recurringCharges) {
        this.recurringCharges = recurringCharges;
    }

    public List<RecurringChargeView> getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(List<RecurringChargeView> roomCharges) {
        this.roomCharges = roomCharges;
    }
}
