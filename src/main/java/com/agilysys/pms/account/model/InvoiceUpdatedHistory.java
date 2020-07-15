/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class InvoiceUpdatedHistory extends BaseInvoiceHistory {
    private String description;

    public InvoiceUpdatedHistory(String eventType, String invoiceNumber, LocalDate invoiceDate, String userId,
          String description) {
        super(eventType, invoiceNumber, invoiceDate, userId);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
