package com.agilysys.pms.account.model.tmp.fixup;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

public class LedgerBalanceFixup {

    String ledgerTransactionId;
    String sourceLedger;
    String sourceAccountId;
    String destLedger;
    String destAccountId;
    LocalDate postingPropertyDate;
    BigDecimal amount;

    public LedgerBalanceFixup() {
    }

    public LedgerBalanceFixup(String ledgerTransactionId, String sourceLedger, String sourceAccountId,
          String destLedger, String destAccountId, LocalDate postingPropertyDate, BigDecimal amount) {
        this.ledgerTransactionId = ledgerTransactionId;
        this.sourceLedger = sourceLedger;
        this.sourceAccountId = sourceAccountId;
        this.destAccountId = destAccountId;
        this.destLedger = destLedger;
        this.postingPropertyDate = postingPropertyDate;
        this.amount = amount;
    }

    public String getLedgerTransactionId() {
        return ledgerTransactionId;
    }

    public void setLedgerTransactionId(String ledgerTransactionId) {
        this.ledgerTransactionId = ledgerTransactionId;
    }

    public String getSourceLedger() {
        return sourceLedger;
    }

    public void setSourceLedger(String sourceLedger) {
        this.sourceLedger = sourceLedger;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getDestLedger() {
        return destLedger;
    }

    public void setDestLedger(String destLedger) {
        this.destLedger = destLedger;
    }

    public String getDestAccountId() {
        return destAccountId;
    }

    public void setDestAccountId(String destAccountId) {
        this.destAccountId = destAccountId;
    }

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
