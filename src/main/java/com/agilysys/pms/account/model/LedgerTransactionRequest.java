/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.DateTime;

/**
 * Ledger Balances for associated with the call type on a specific time period
 */
public class LedgerTransactionRequest {

    private String callType;
    private DateTime startDateTime;
    private DateTime endDateTime;

    public LedgerTransactionRequest(String callType, DateTime startDateTime, DateTime endDateTime) {
        this.callType = callType;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public String getCallType() {
        return callType;
    }

    public DateTime getStartDateTime() {
        return startDateTime;
    }

    public DateTime getEndDateTime() {
        return endDateTime;
    }
}
