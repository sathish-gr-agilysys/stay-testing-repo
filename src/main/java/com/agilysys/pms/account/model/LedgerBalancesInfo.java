package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

/**
 * Ledger Balances for a property and date
 */

public class LedgerBalancesInfo {
    private LocalDate date;
    private String propertyId;

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }
}
