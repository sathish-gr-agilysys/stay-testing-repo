/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 *
 * @author tercerose
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public class TransactionReportResponse {
    Map<LocalDate, List<TransactionReportItem>> transactionsByAccountId;

    public Map<LocalDate, List<TransactionReportItem>> getTransactionsByAccountId() {
        return transactionsByAccountId;
    }

    public void setTransactionsByAccountId(Map<LocalDate, List<TransactionReportItem>> transactionsByAccountId) {
        this.transactionsByAccountId = transactionsByAccountId;
    }
}
