/*
 *  (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.payagent.model.events;

import java.util.List;

import org.springframework.data.annotation.Transient;

import com.agilysys.platform.persistence.eventsourcing.PropertyLevelIdentifier;
import com.agilysys.pms.rguestpayshim.model.PayAgentBaseResponse;

/**
 * Event to handle errors Pay during interaction with PayAgent or accountProcessing
 */
public class PayAgentTransactionFailedEvent extends PayAgentTransactionEvent {
    private PropertyLevelIdentifier id;
    private PayAgentBaseResponse response;
    private String errorCode;
    private String errorDescription;

    public PayAgentTransactionFailedEvent() {}

    public PayAgentTransactionFailedEvent(PropertyLevelIdentifier identifier, PayAgentBaseResponse response) {
        this.id = identifier;
        this.response = response;
    }

    public PropertyLevelIdentifier getId() {
        return id;
    }

    public PayAgentBaseResponse getResponse() {
        return response;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "PayAgentTransaction Failed";
    }

    @Override
    public List<String> getHistoryMessages() {
        return null;
    }
}
