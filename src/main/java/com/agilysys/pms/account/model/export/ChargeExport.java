/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

/**
 * A Charge posted to an account
 *
 * @see <a
 * href="http://confluence.bellevue.ad.local/display/VICTRIAL/Charge+Object">Confluence:
 * Charge Object</a>
 */
public class ChargeExport extends TransactionExport {
    private String mealPeriodId;
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
}
