package com.agilysys.pms.account.model;

public class DisputedARLedgerTransaction {
    private String ledgerTransactionId;
    private boolean dispute;

    public DisputedARLedgerTransaction() { }

    public DisputedARLedgerTransaction(String ledgerTransactionId, boolean dispute) {
        this.ledgerTransactionId = ledgerTransactionId;
        this.dispute = dispute;
    }

    public String getLedgerTransactionId() {
        return ledgerTransactionId;
    }

    public void setLedgerTransactionId(String ledgerTransactionId) {
        this.ledgerTransactionId = ledgerTransactionId;
    }

    public boolean isDispute() {
        return dispute;
    }

    public void setDispute(boolean dispute) {
        this.dispute = dispute;
    }
}
