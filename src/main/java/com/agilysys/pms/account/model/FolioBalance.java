/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

/**
 * Folio model including the total balance.
 */
public class FolioBalance extends FolioSummary {
    private BigDecimal balance;
    private BigDecimal taxBalance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTaxBalance() {
        return taxBalance;
    }

    public void setTaxBalance(BigDecimal taxBalance) {
        this.taxBalance = taxBalance;
    }
}
