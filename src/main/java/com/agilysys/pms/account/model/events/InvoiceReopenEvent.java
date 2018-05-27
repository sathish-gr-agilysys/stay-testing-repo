package com.agilysys.pms.account.model.events;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;

public class InvoiceReopenEvent extends InvoiceBalanceChangeEvent {

    private PropertyLevelIdentifier id;
    private String accountId;
    private LocalDate invoiceDate;
    private String invoiceNumber;
    private Set<String> folioLineItemIds;

    public InvoiceReopenEvent(){}

    public InvoiceReopenEvent(PropertyLevelIdentifier id, String accountId, LocalDate invoiceDate, String invoiceNumber, Set<String> folioLineItemIds, boolean closed) {
        super(closed);
        this.id = id;
        this.accountId = accountId;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.folioLineItemIds = folioLineItemIds;
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

    public Set<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Invoice ReOpened";
    }

    @Override
    public List<String> getHistoryMessages() {
        return Arrays.asList(String.format("Invoice %s reopened.", invoiceNumber));
    }

}