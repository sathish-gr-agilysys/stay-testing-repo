/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.google.common.base.Objects;

/**
 * A Charge posted to an account.
 */
public class Charge extends Transaction {
    private String mealPeriodId;
    private String recurringChargeId;
    private TransactionItemType transactionItemType;

    public String getMealPeriodId() {
        return mealPeriodId;
    }

    public void setMealPeriodId(String mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public String getRecurringChargeId() {
        return recurringChargeId;
    }

    public void setRecurringChargeId(String recurringChargeId) {
        this.recurringChargeId = recurringChargeId;
    }

    public TransactionItemType getTransactionItemType() {
        return transactionItemType;
    }

    public void setTransactionItemType(TransactionItemType transactionItemType) {
        this.transactionItemType = transactionItemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Charge that = (Charge) o;

        return Objects.equal(mealPeriodId, that.mealPeriodId) &&
              Objects.equal(quantity, that.quantity) &&
              Objects.equal(recurringChargeId, that.recurringChargeId) &&
              Objects.equal(transactionItemType, that.transactionItemType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), mealPeriodId, quantity, recurringChargeId, transactionItemType);
    }
}
