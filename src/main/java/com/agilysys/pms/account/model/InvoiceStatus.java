package com.agilysys.pms.account.model;

public enum InvoiceStatus {
    //TODO: add Disputed status when we have that functionality
    CLOSED,
    GENERATED,
    MODIFIED,
    OVERDUE,
    SENT_EMAIL,
    SENT_PRINT,
    VOIDED
}