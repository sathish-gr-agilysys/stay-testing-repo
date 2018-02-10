/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class LedgerTransactionTransferDetail {
    List<LedgerTransactionHistoryView> ledgerTransactionHistoryViews;
    List<LedgerTransactionAccountData> ledgerTransactionAccountData;

    public LedgerTransactionTransferDetail(){
        ledgerTransactionAccountData = new ArrayList<>();
        ledgerTransactionHistoryViews = new ArrayList<>();
    }

    public List<LedgerTransactionAccountData> getLedgerTransactionAccountData() {
        return ledgerTransactionAccountData;
    }

    public void setLedgerTransactionAccountData(List<LedgerTransactionAccountData> ledgerTransactionAccountData) {
        this.ledgerTransactionAccountData = ledgerTransactionAccountData;
    }

    public List<LedgerTransactionHistoryView> getLedgerTransactionHistoryViews() {
        return ledgerTransactionHistoryViews;
    }

    public void setLedgerTransactionHistoryViews(List<LedgerTransactionHistoryView> ledgerTransactionHistoryViews) {
        this.ledgerTransactionHistoryViews = ledgerTransactionHistoryViews;
    }
}
