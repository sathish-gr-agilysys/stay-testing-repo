/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.agilysys.pms.account.model.Balance;

public abstract class InvoiceBalanceChangeEvent extends InvoiceEvent {

    private Balance balance;

    public InvoiceBalanceChangeEvent() { super(); }

    public InvoiceBalanceChangeEvent(List<Map<String, Object>> historyMetadata) {
        super(historyMetadata);
    }

    public InvoiceBalanceChangeEvent(DateTime eventDate, List<Map<String, Object>> historyMetadata) {
        super(eventDate, historyMetadata);
    }

    public InvoiceBalanceChangeEvent(Balance balance) {
        super();
        this.balance = balance;
    }

    public InvoiceBalanceChangeEvent(List<Map<String, Object>> historyMetadata, Balance balance) {
        super(historyMetadata);
        this.balance = balance;
    }

    public Balance getBalance() { return balance; }
}
