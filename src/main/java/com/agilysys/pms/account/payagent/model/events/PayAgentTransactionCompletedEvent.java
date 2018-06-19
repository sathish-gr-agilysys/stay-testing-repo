package com.agilysys.pms.account.payagent.model.events;

import java.util.List;

import org.elasticsearch.common.collect.Lists;
import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;
import com.agilysys.pms.rguestpayshim.model.PayAgentBaseResponse;

/**
 * Event to Complete an existing Pay Agent Transaction
 */
public class PayAgentTransactionCompletedEvent extends PayAgentTransactionEvent {
    private PropertyLevelIdentifier id;
    private PayAgentBaseResponse response;

    public PayAgentTransactionCompletedEvent() {
        super();
    }

    public PayAgentTransactionCompletedEvent(PropertyLevelIdentifier identifier, PayAgentBaseResponse response) {
        super();
        this.id = identifier;
        this.response = response;
    }

    public PropertyLevelIdentifier getId() {
        return id;
    }

    public PayAgentBaseResponse getResponse() {
        return response;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "PayAgentTransaction Completed";
    }

    @Override
    public List<String> getHistoryMessages() {
        return Lists.newArrayList();
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

}
