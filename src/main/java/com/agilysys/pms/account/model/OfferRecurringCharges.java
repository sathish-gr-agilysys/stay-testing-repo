/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class OfferRecurringCharges {

    private LocalDate chargeDate;
    private List<OfferRecurringItem> items;

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
    }

    public List<OfferRecurringItem> getItems() {
        return items;
    }

    public void setItems(List<OfferRecurringItem> items) {
        this.items = items;
    }
}
