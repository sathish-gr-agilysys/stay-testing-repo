package com.agilysys.pms.account.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.pms.account.LedgerTransactionhistoryAccountData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by MuthalurajG on 10/9/2017.
 */

@JsonInclude
public class LedgerTransactionHistoryView {

    private String id;

    String tenantId;

    String propertyId;

    private LedgerTransactionhistoryAccountData sourceInfo;

    private LedgerTransactionhistoryAccountData destinationInfo;

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

    public LedgerTransactionhistoryAccountData getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(LedgerTransactionhistoryAccountData sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public LedgerTransactionhistoryAccountData getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(LedgerTransactionhistoryAccountData destinationInfo) {
        this.destinationInfo = destinationInfo;
    }

    public void toHistoryView(String id, String reason, LedgerTransactionhistoryAccountData sourceInfo,
          LedgerTransactionhistoryAccountData destinationInfo, DateTime dateTime,String tenantId,String propertyId) {
        this.id = id;
        this.reason = reason;
        this.dateTime = dateTime;
        this.sourceInfo = sourceInfo;
        this.destinationInfo = destinationInfo;
        this.tenantId=tenantId;
        this.propertyId=propertyId;
    }
}
