package com.agilysys.pms.account.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.UUID;

/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
public class LedgerTransactionHistory {

    public LedgerTransactionHistory(){
        this.id= UUID.randomUUID().toString();
    }

    private String id;

    private String sourceId;

    private String sourceAccountType;

    private String destinationId;

    private String destinationAccountType;

    private String reason;

    private DateTime dateTime;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationAccountType() {
        return destinationAccountType;
    }

    public void setDestinationAccountType(String destinationAccountType) {
        this.destinationAccountType = destinationAccountType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
