/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class LedgerTransactionTransferDetail {
    List<LedgerTransactionHistoryView> transferHistory;
    List<LedgerTransactionAccountDetail> linkInfo;

    public LedgerTransactionTransferDetail(){
        linkInfo = new ArrayList<>();
        transferHistory = new ArrayList<>();
    }

    public List<LedgerTransactionAccountDetail> getLinkInfo() {
        return linkInfo;
    }

    public void setLinkInfo(List<LedgerTransactionAccountDetail> linkInfo) {
        this.linkInfo = linkInfo;
    }

    public List<LedgerTransactionHistoryView> getTransferHistory() {
        return transferHistory;
    }

    public void setTransferHistory(List<LedgerTransactionHistoryView> transferHistory) {
        this.transferHistory = transferHistory;
    }
}
