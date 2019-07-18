/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.List;

/**
 * Params for generating a non-ivoice charges print report
 */
public class NonInvoiceReport {

    private List<String> ledgerTransactionIds;

    public List<String> getLedgerTransactionIds() {
        return ledgerTransactionIds;
    }

    public void setLedgerTransactionIds(List<String> ledgerTransactionIds) {
        this.ledgerTransactionIds = ledgerTransactionIds;
    }

}