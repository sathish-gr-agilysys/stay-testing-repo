/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 *
 * @author tercerose
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class TransactionReportResponse {
    Map<String, List<TransactionReportItem>> transactionsByAccountId;

    public Map<String, List<TransactionReportItem>> getTransactionsByAccountId() {
        return transactionsByAccountId;
    }

    public void setTransactionsByAccountId(Map<String, List<TransactionReportItem>> transactionsByAccountId) {
        this.transactionsByAccountId = transactionsByAccountId;
    }
}
