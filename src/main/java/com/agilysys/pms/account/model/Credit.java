/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

/**
 * A Credit posted to an account
 *
 * @see <a
 * href="http://confluence.bellevue.ad.local/display/VICTRIAL/Charge+Object">Confluence:
 * Credit Object</a>
 */
public class Credit extends TaxableTransaction {
    private TransactionItemType transactionItemType;

    public TransactionItemType getTransactionItemType() {
        return transactionItemType;
    }

    public void setTransactionItemType(TransactionItemType transactionItemType) {
        this.transactionItemType = transactionItemType;
    }

    @Override
    public BigDecimal getExpectedGrossAmount() {
        BigDecimal expectedGrossAmount = super.getExpectedGrossAmount();
        if (expectedGrossAmount != null) {
            return expectedGrossAmount.negate();
        }

        return expectedGrossAmount;
    }
}
