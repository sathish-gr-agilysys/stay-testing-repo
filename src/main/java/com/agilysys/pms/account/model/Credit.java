/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

/**
 * A Credit posted to an account
 *
 * @see <a
 * href="http://confluence.bellevue.ad.local/display/VICTRIAL/Charge+Object">Confluence:
 * Credit Object</a>
 */
public class Credit extends Transaction {
    private TransactionItemType transactionItemType;

    public TransactionItemType getTransactionItemType() {
        return transactionItemType;
    }

    public void setTransactionItemType(TransactionItemType transactionItemType) {
        this.transactionItemType = transactionItemType;
    }
}
