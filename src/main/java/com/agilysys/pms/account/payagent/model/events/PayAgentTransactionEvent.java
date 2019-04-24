/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.payagent.model.events;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

import com.agilysys.pms.account.model.payagent.PayAgentResponseType;
import com.agilysys.pms.account.model.payagent.PayRequestType;
import com.agilysys.pms.common.model.StayDomainEvent;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS)
public abstract class PayAgentTransactionEvent extends StayDomainEvent {
    protected List<Map<String, Object>> historyMetadata = new LinkedList<>();

    protected PayRequestType payRequestType;
    protected PayAgentResponseType payResponseType;

    public PayAgentTransactionEvent() {
        super();
    }

    public PayAgentTransactionEvent(DateTime eventDate) {
        super(eventDate);
    }

    /**
     * @return the payRequestType
     */
    public PayRequestType getPayRequestType() {
        return payRequestType;
    }

    /**
     * @param payRequestType the payRequestType to set
     */
    public void setPayRequestType(PayRequestType payRequestType) {
        this.payRequestType = payRequestType;
    }

    /**
     * @return the payResponseType
     */
    public PayAgentResponseType getPayResponseType() {
        return payResponseType;
    }

    /**
     * @param payResponseType the payResponseType to set
     */
    public void setPayResponseType(PayAgentResponseType payResponseType) {
        this.payResponseType = payResponseType;
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
