/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.common.model.rate.AllowanceCombination;
import com.google.common.base.Objects;

/**
 * A Charge posted to an account.
 */
public class Charge extends Transaction {
    private String mealPeriodId;
    private String recurringChargeId;
    private TransactionItemType transactionItemType;
    private String autoRecurringItemId;
    private boolean notGrouped;

    public Charge() {}

    public Charge(BigDecimal amount, String descriptionOverride, String folioId, int quantity, boolean notGrouped,
          String itemId) {
        this.amount = amount;
        this.descriptionOverride = descriptionOverride;
        this.folioId = folioId;
        this.quantity = quantity;
        this.notGrouped = notGrouped;
        this.itemId = itemId;
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

    public boolean isNotGrouped() {
        return notGrouped;
    }

    public void setNotGrouped(boolean notGrouped) {
        this.notGrouped = notGrouped;
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
              Objects.equal(transactionItemType, that.transactionItemType) &&
              Objects.equal(autoRecurringItemId, that.autoRecurringItemId) && Objects.equal(notGrouped, that.notGrouped);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), mealPeriodId, quantity, recurringChargeId, transactionItemType,
              autoRecurringItemId, notGrouped);
    }

    @Override
    public AllowanceCombination toAllowanceCombination() {
        if (mealPeriodId == null || sourceId == null || itemId == null) {
            return null;
        }
        return new AllowanceCombination(mealPeriodId, sourceId, itemId);
    }
}
