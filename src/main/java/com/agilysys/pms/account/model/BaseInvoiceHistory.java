/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.DateTime;

public class BaseInvoiceHistory {
    private String eventType;
    private String invoiceNumber;
    private DateTime invoiceDate;
    private String userId;

    public BaseInvoiceHistory() {
    }

    public BaseInvoiceHistory(String eventType, String invoiceNumber, DateTime invoiceDate, String userId) {
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

    public DateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(DateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
