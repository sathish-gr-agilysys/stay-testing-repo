/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.pms.account.model.events.InvoiceEvent;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class RawEventsResult {
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private List<InvoiceEvent> events = Lists.newLinkedList();

    public RawEventsResult() {

    }

    public RawEventsResult(List<InvoiceEvent> events) {
        this.events = ImmutableList.copyOf(events);
    }

    public List<InvoiceEvent> getEvents() {
        return events;
    }
}
