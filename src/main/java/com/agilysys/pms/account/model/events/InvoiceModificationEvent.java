/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

public abstract class InvoiceModificationEvent extends InvoiceEvent {
    private boolean closed;

    public InvoiceModificationEvent(boolean closed) {
        super();

        this.closed = closed;
    }

    public InvoiceModificationEvent(DateTime eventDate, boolean closed) {
        super(eventDate);

        this.closed = closed;
    }

    public InvoiceModificationEvent(DateTime eventDate, List<Map<String, Object>> historyMetadata, boolean closed) {
        super(eventDate, historyMetadata);

        this.closed = closed;
    }

    public boolean isClosed() { return closed; }
}
