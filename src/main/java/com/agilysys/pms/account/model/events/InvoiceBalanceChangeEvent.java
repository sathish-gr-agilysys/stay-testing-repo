/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

public abstract class InvoiceBalanceChangeEvent extends InvoiceEvent {

    public InvoiceBalanceChangeEvent() { super(); }

    public InvoiceBalanceChangeEvent(List<Map<String, Object>> historyMetadata) {
        super(historyMetadata);
    }

    public InvoiceBalanceChangeEvent(DateTime eventDate, List<Map<String, Object>> historyMetadata) {
        super(eventDate, historyMetadata);
    }

}
