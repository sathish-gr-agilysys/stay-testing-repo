/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.pms.account.model.LedgerTransactionHistoryAccountData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LedgerTransactionHistoryView {

    private String id;

    String tenantId;

    String propertyId;

    private LedgerTransactionHistoryAccountData sourceInfo;

    private LedgerTransactionHistoryAccountData destinationInfo;

    private String reason;

    private DateTime dateTime;

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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public LedgerTransactionHistoryAccountData getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(LedgerTransactionHistoryAccountData sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public LedgerTransactionHistoryAccountData getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(LedgerTransactionHistoryAccountData destinationInfo) {
        this.destinationInfo = destinationInfo;
    }

    public void toHistoryView(String id, String reason, LedgerTransactionHistoryAccountData sourceInfo,
          LedgerTransactionHistoryAccountData destinationInfo, DateTime dateTime,String tenantId,String propertyId) {
        this.id = id;
        this.reason = reason;
        this.dateTime = dateTime;
        this.sourceInfo = sourceInfo;
        this.destinationInfo = destinationInfo;
        this.tenantId=tenantId;
        this.propertyId=propertyId;
    }
}
