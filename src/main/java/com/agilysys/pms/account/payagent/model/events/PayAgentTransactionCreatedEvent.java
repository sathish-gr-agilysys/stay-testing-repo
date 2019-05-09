/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.payagent.model.events;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;
import com.agilysys.pms.account.model.payagent.PayTransactionRequest;
import com.agilysys.pms.rguestpayshim.model.PayAgentBaseRequest;

/**
 * Event to create a payTransaction document.
 */
public class PayAgentTransactionCreatedEvent extends PayAgentTransactionEvent {
    private PropertyLevelIdentifier id;
    private PayTransactionRequest payTransactionRequest;
    private PayAgentBaseRequest payAgentPayLoad;
    private String callbackUrl;

    public PayAgentTransactionCreatedEvent() {
        super();
    }

    public PayAgentTransactionCreatedEvent(PropertyLevelIdentifier id, PayTransactionRequest payTransactionRequest) {
        super();
        this.id = id;
        this.payTransactionRequest = payTransactionRequest;
    }

    public PropertyLevelIdentifier getId() {
        return id;
    }

    /**
     * @return the payTransactionRequest
     */
    public PayTransactionRequest getPayTransactionRequest() {
        return payTransactionRequest;
    }

    /**
     * @param payTransactionRequest the payTransactionRequest to set
     */
    public void setPayTransactionRequest(PayTransactionRequest payTransactionRequest) {
        this.payTransactionRequest = payTransactionRequest;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "PayAgentTransaction Created";
    }

    @Override
    public List<String> getHistoryMessages() {
        return Arrays.asList(String.format("PayAgentTransaction created : " + id));
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * @return the payAgentPayLoad
     */
    public PayAgentBaseRequest getPayAgentPayLoad() {
        return payAgentPayLoad;
    }

    /**
     * @param payAgentPayLoad the payAgentPayLoad to set
     */
    public void setPayAgentPayLoad(PayAgentBaseRequest payAgentPayLoad) {
        this.payAgentPayLoad = payAgentPayLoad;
    }
}
