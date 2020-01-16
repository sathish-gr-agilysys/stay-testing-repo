/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class RecurringChargesPostingResult {
    private List<ChargePostingError> errors = new ArrayList<>();
    private List<RecurringChargeView> recurringCharges = new ArrayList<>();
    private List<RecurringChargeView> roomCharges = new ArrayList<>();
    List<BreakageChargesPostingError> breakageChargesPostingErrors = new ArrayList<>();

    public List<ChargePostingError> getErrors() {
        return errors;
    }

    public void setErrors(List<ChargePostingError> errors) {
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

    public List<BreakageChargesPostingError> getBreakageChargesPostingErrors() {
        return breakageChargesPostingErrors;
    }

    public void setBreakageChargesPostingErrors(List<BreakageChargesPostingError> breakageChargesPostingErrors) {
        this.breakageChargesPostingErrors = breakageChargesPostingErrors;
    }
}
