/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

/**
 * View for the property to get all recurring charges for the current day.
 */
public class RecurringChargesPropertyView {
    private List<RecurringChargeView> recurringCharges;
    private List<RecurringChargeView> roomCharges;

    public RecurringChargesPropertyView() {
        recurringCharges = new ArrayList<>();
        roomCharges = new ArrayList<>();
    }

    public RecurringChargesPropertyView(List<RecurringChargeView> recurringCharges,
          List<RecurringChargeView> roomCharges) {
        this.recurringCharges = recurringCharges;
        this.roomCharges = roomCharges;
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
