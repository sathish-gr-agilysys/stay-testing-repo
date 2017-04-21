/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;
import com.agilysys.pms.account.model.InvoiceRequest;

public class InvoiceCreatedEvent extends InvoiceEvent {
    private PropertyLevelIdentifier id;
    private String accountId;
    private LocalDate invoiceDate;
    private List<String> folioLineItemIds;
    private int terms;
    private String invoiceNumber;
    private boolean closed;

    public InvoiceCreatedEvent() {
        super();
    }

    public InvoiceCreatedEvent(PropertyLevelIdentifier id, String accountId, InvoiceRequest invoiceRequest,
          String invoiceNumber, boolean closed) {
        super();

        this.id = id;
        this.accountId = accountId;
        this.invoiceDate = invoiceRequest.getInvoiceDate();
        this.folioLineItemIds = invoiceRequest.getFolioLineItemIds();
        this.terms = invoiceRequest.getTerms();
        this.invoiceNumber = invoiceNumber;
        this.closed = closed;
    }

    public PropertyLevelIdentifier getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public List<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    public int getTerms() {
        return terms;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Invoice Created";
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public boolean isClosed() { return closed; }

    @Override
    public List<String> getHistoryMessages() {
        return Arrays.asList(String.format("Invoice %s created.", invoiceNumber));
    }
}
