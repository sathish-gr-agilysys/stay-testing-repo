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
    Map<LocalDate, List<TransactionReportItem>> transactionsByDate;

    public Map<LocalDate, List<TransactionReportItem>> getTransactionsByDate() {
        return transactionsByDate;
    }

    public void setTransactionsByDate(Map<LocalDate, List<TransactionReportItem>> transactionsByDate) {
        this.transactionsByDate = transactionsByDate;
    }
}
