/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.google.common.base.Objects;

/**
 * A Charge posted to an account.
 */
public class Charge extends Transaction {
    private boolean preCheckCredit;
    private String mealPeriodId;
    private String recurringChargeId;
    private TransactionItemType transactionItemType;
    private String autoRecurringItemId;

    public boolean isPreCheckCredit() {
        return preCheckCredit;
    }

    public void setPreCheckCredit(boolean preCheckCredit) {
        this.preCheckCredit = preCheckCredit;
    }

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

    public String getAutoRecurringItemId() {
        return autoRecurringItemId;
    }

    public void setAutoRecurringItemId(String autoRecurringItemId) {
        this.autoRecurringItemId = autoRecurringItemId;
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

        return Objects.equal(preCheckCredit, that.preCheckCredit) &&
              Objects.equal(mealPeriodId, that.mealPeriodId) &&
              Objects.equal(quantity, that.quantity) &&
              Objects.equal(recurringChargeId, that.recurringChargeId) &&
              Objects.equal(transactionItemType, that.transactionItemType) &&
              Objects.equal(autoRecurringItemId, that.autoRecurringItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), preCheckCredit, mealPeriodId, quantity, recurringChargeId,
              transactionItemType, autoRecurringItemId);
    }
}
