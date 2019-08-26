/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

/**
 * Needed because transaction is abstract
 */
public class PaymentTransaction extends Transaction {
    public PaymentTransaction() {
    }

    public PaymentTransaction(String accountId, BigDecimal amount, String itemId) {
        this.accountId = accountId;
        this.amount = amount;
        this.itemId = itemId;
    }

    public void toTransaction(String accountId, String folioId, Boolean pantryItem) {
        this.accountId = accountId;
        this.folioId = folioId;
        this.pantryItem = pantryItem;
    }

}
