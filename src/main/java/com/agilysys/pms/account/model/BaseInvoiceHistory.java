/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class BaseInvoiceHistory {
    private String eventType;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private String userId;

    public BaseInvoiceHistory() {
    }

    public BaseInvoiceHistory(String eventType, String invoiceNumber, LocalDate invoiceDate, String userId) {
        this.eventType = eventType;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
