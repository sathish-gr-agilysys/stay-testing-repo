/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoiceUpdatedHistory extends BaseInvoiceHistory {
    private List<String> description;

    public InvoiceUpdatedHistory(String eventType, String invoiceNumber, DateTime invoiceDate, String userId,
          List<String> description) {
        super(eventType, invoiceNumber, invoiceDate, userId);
        this.description = description;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
