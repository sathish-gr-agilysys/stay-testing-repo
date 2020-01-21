/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Type of transaction posting.
 */
public enum TransactionType {
    ADJUSTMENT(false),
    CHARGE(false),
    COMP(true),
    CORRECTION(false),
    CREDIT(true),
    GROUP(false),
    LEDGERTRANSFER(false),
    PAYMENT(true),
    REFUND(true),
    REVERSE_COMP(true),
    TRANSFER(false),
    VOID(false);

    private boolean negate;

    public boolean negate() {
        return negate;
    }

    TransactionType(boolean negate) {
        this.negate = negate;
    }

    public static final List<TransactionType> TRANSACTION_TYPES = Collections.unmodifiableList(Arrays.asList(
          TransactionType.ADJUSTMENT, TransactionType.CHARGE, TransactionType.CORRECTION, TransactionType.CREDIT,
          TransactionType.PAYMENT, TransactionType.REFUND, TransactionType.TRANSFER));
}
