/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class TaxAmountInfo {
    String taxRuleId;
    BigDecimal amount;
    String folioDescription;
    String ledgerDescription;
    String itemId;

    public String getTaxRuleId() {
        return taxRuleId;
    }

    public void setTaxRuleId(String taxRuleId) {
        this.taxRuleId = taxRuleId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFolioDescription() {
        return folioDescription;
    }

    public void setFolioDescription(String folioDescription) {
        this.folioDescription = folioDescription;
    }

    public String getLedgerDescription() {
        return ledgerDescription;
    }

    public void setLedgerDescription(String ledgerDescription) {
        this.ledgerDescription = ledgerDescription;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
