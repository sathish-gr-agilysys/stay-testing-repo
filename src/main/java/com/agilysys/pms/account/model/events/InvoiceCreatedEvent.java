/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;

public class InvoiceCreatedEvent extends InvoiceModificationEvent {
    private PropertyLevelIdentifier id;
    private String accountId;
    private LocalDate invoiceDate;
    private List<String> folioLineItemIds;
    private int terms;
    private String invoiceNumber;

    public InvoiceCreatedEvent(PropertyLevelIdentifier id, String accountId, LocalDate invoiceDate,
          List<String> folioLineItemIds, int terms, String invoiceNumber, boolean closed) {
        super(closed);

        this.id = id;
        this.accountId = accountId;
        this.invoiceDate = invoiceDate;
        this.folioLineItemIds = folioLineItemIds;
        this.terms = terms;
        this.invoiceNumber = invoiceNumber;
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

    @Override
    public List<String> getHistoryMessages() {
        return Arrays.asList(String.format("Invoice %s created.", invoiceNumber));
    }
}
