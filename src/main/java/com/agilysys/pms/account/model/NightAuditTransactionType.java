package com.agilysys.pms.account.model;

public enum NightAuditTransactionType {
    /**
     * represents all payments on a ledger
     */
    PAYMENT,
    /**
     * represents all ledger transfers
     */
    TRANSFER,
    /**
     * represents all other transaction types
     */
    CHARGE;
}
