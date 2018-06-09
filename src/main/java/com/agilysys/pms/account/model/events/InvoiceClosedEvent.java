/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;

public class InvoiceClosedEvent extends InvoiceBalanceChangeEvent {

    private PropertyLevelIdentifier id;
    private String accountId;
    private LocalDate invoiceDate;
    private String invoiceNumber;

    public InvoiceClosedEvent() {}

    public InvoiceClosedEvent(PropertyLevelIdentifier id, String accountId, LocalDate invoiceDate, String invoiceNumber) {
        this.id = id;
        this.accountId = accountId;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
    }

    public PropertyLevelIdentifier getId() {
        return id;
    }

    public void setId(PropertyLevelIdentifier id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Invoice Closed";
    }

    @Override
    public List<String> getHistoryMessages() {
        return Arrays.asList(String.format("Invoice %s closed.", invoiceNumber));
    }

}
