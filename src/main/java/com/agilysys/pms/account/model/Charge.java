/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.platform.common.json.schema.MinValueRestriction;

/**
 * A Charge posted to an account
 *
 * @see <a
 * href="http://confluence.bellevue.ad.local/display/VICTRIAL/Charge+Object">Confluence:
 * Charge Object</a>
 */
public class Charge extends Transaction {
    private String mealPeriodId;

    @MinValueRestriction(1)
    private int quantity;

    private String recurringChargeId;

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return (quantity < 1 ? 1 : quantity);
    }

    /**
     * @param quantity Optional quantity. Must be greater than or equal to 1. If less
     *                 than 1, will automatically be set to 1.
     */
    public void setQuantity(int quantity) {
        this.quantity = (quantity < 1 ? 1 : quantity);
    }

    /**
     * @return the mealPeriodId
     */
    public String getMealPeriodId() {
        return mealPeriodId;
    }

    /**
     * @param mealPeriodId Optional ID of mealPeriod
     */
    public void setMealPeriodId(String mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public String getRecurringChargeId() {
        return recurringChargeId;
    }

    public void setRecurringChargeId(String recurringChargeId) {
        this.recurringChargeId = recurringChargeId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(7).append(mealPeriodId).append(recurringChargeId).append(quantity)
              .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Charge rhs = (Charge) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj)).append(mealPeriodId, rhs.mealPeriodId)
              .append(recurringChargeId, rhs.recurringChargeId).append(quantity, rhs.quantity).isEquals();
    }

}
