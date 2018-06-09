/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;

public class InvoiceCloseOrReopenEvent extends InvoiceBalanceChangeEvent {

    private PropertyLevelIdentifier id;
    private String accountId;
    private LocalDate invoiceDate;
    private String invoiceNumber;
    boolean isClosed;

    public InvoiceCloseOrReopenEvent(){}

    public InvoiceCloseOrReopenEvent(PropertyLevelIdentifier id, String accountId, LocalDate invoiceDate,
          String invoiceNumber, boolean isClosed){
        super(isClosed);

        this.id = id;
        this.accountId = accountId;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public List<String> getHistoryMessages() {
        if(isClosed()){
            return Arrays.asList(String.format("Invoice %s closed.", invoiceNumber));
        }else{
            return Arrays.asList(String.format("Invoice %s reopened.", invoiceNumber));
        }
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        if(isClosed()){
            return"Invoice closed";
        }else{
            return "Invoice reopened";
        }
    }
}
