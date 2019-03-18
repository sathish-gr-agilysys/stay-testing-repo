/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class FolioInvoicePropertyData {

    private boolean reservationAliasEnabled;
    private String reservationAlias;

    public boolean isReservationAliasEnabled() {
        return reservationAliasEnabled;
    }

    public void setReservationAliasEnabled(boolean reservationAliasEnabled) {
        this.reservationAliasEnabled = reservationAliasEnabled;
    }

    public String getReservationAlias() {
        return reservationAlias;
    }

    public void setReservationAlias(String reservationAlias) {
        this.reservationAlias = reservationAlias;
    }
}
