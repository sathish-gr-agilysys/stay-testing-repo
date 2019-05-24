/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Objects;

public class RecurringChargeDetail {
    private String recurringChargeId;
    private String itemId;
    private int quantity;

    public String getRecurringChargeId() {
        return recurringChargeId;
    }

    public void setRecurringChargeId(String recurringChargeId) {
        this.recurringChargeId = recurringChargeId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecurringChargeDetail)) return false;
        RecurringChargeDetail that = (RecurringChargeDetail) o;
        return Objects.equals(recurringChargeId, that.recurringChargeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recurringChargeId);
    }
}
