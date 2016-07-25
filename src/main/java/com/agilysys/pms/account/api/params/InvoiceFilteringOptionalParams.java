/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api.params;

import org.joda.time.LocalDate;

public class InvoiceFilteringOptionalParams {
    private boolean includeClosed;
    private LocalDate startDate;
    private LocalDate endDate;
    private String invoiceNumber;

    public boolean getIncludeClosed() {
        return includeClosed;
    }

    public void setIncludeClosed(boolean includeClosed) {
        this.includeClosed = includeClosed;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
