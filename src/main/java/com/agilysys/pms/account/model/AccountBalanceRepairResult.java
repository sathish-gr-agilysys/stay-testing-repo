/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Collection;
import java.util.Map;

public class AccountBalanceRepairResult {
    private int missingLedgerTransactions;
    private int missingLineItems;
    private Integer mapReduceTimeMs;
    private Map<String, Collection<String>> ledgerTransactionsByAccount;

    public int getMissingLedgerTransactions() {
        return missingLedgerTransactions;
    }

    public void setMissingLedgerTransactions(int missingLedgerTransactions) {
        this.missingLedgerTransactions = missingLedgerTransactions;
    }

    public int getMissingLineItems() {
        return missingLineItems;
    }

    public void setMissingLineItems(int missingLineItems) {
        this.missingLineItems = missingLineItems;
    }

    public Integer getMapReduceTimeMs() {
        return mapReduceTimeMs;
    }

    public void setMapReduceTimeMs(Integer mapReduceTimeMs) {
        this.mapReduceTimeMs = mapReduceTimeMs;
    }

    public Map<String, Collection<String>> getLedgerTransactionsByAccount() {
        return ledgerTransactionsByAccount;
    }

    public void setLedgerTransactionsByAccount(Map<String, Collection<String>> ledgerTransactionsByAccount) {
        this.ledgerTransactionsByAccount = ledgerTransactionsByAccount;
    }
}
