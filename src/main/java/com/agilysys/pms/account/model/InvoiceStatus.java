package com.agilysys.pms.account.model;

public enum InvoiceStatus {
    //TODO: add Disputed status when we have that functionality
    GENERATED,
    MODIFIED,
    SENT_EMAIL,
    SENT_PRINT,
    OVERDUE,
    CLOSED
}

