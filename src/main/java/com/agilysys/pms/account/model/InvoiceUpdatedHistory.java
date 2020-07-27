/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class InvoiceUpdatedHistory extends BaseInvoiceHistory {
    private List<String> description;
    private List<String> emailAddresses;

    public InvoiceUpdatedHistory(String eventType, String invoiceNumber, DateTime invoiceDate, String userId,
          List<String> description, List<String> emailAddresses) {
        super(eventType, invoiceNumber, invoiceDate, userId);
        this.description = description;
        this.emailAddresses = emailAddresses;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }
}
