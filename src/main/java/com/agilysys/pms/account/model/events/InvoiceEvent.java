/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

import com.agilysys.pms.common.model.StayDomainEvent;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS)
public abstract class InvoiceEvent extends StayDomainEvent {
    protected List<Map<String, Object>> historyMetadata = new LinkedList<>();

    public InvoiceEvent() {
        super();
    }

    public InvoiceEvent(DateTime eventDate) {
        super(eventDate);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public List<Map<String, Object>> getHistoryMetadata() {
        return historyMetadata;
    }

    public abstract List<String> getHistoryMessages();
}
