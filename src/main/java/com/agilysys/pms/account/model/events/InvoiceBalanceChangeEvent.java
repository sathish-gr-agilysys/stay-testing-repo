/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.agilysys.pms.account.model.Balance;

public abstract class InvoiceBalanceChangeEvent extends InvoiceEvent {
    private boolean closed;
    private Balance balance;

    public InvoiceBalanceChangeEvent() { super(); }

    public InvoiceBalanceChangeEvent(boolean closed) {
        super();
        this.closed = closed;
    }

    public InvoiceBalanceChangeEvent(Balance balance) {
        super();
        this.balance = balance;
    }

    public InvoiceBalanceChangeEvent(boolean closed, Balance balance) {
        this(closed);
        this.balance = balance;
    }

    public InvoiceBalanceChangeEvent(List<Map<String, Object>> historyMetadata, boolean closed) {
        super(historyMetadata);
        this.closed = closed;
    }

    public InvoiceBalanceChangeEvent(List<Map<String, Object>> historyMetadata, boolean closed, Balance balance) {
        this(historyMetadata, closed);
        this.balance = balance;
    }

    public InvoiceBalanceChangeEvent(DateTime eventDate, List<Map<String, Object>> historyMetadata, boolean closed) {
        super(eventDate, historyMetadata);
        this.closed = closed;
    }

    public boolean isClosed() { return closed; }

    public Balance getBalance() { return balance; }
}
