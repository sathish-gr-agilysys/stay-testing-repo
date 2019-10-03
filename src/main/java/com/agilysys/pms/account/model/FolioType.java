/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public enum FolioType {
    GUEST(true, false),
    PACKAGE(false, false),
    THIRD_PARTY(false, false);

    private boolean guestFolio;
    private boolean restrictive;

    public boolean isGuestFolio() {
        return guestFolio;
    }

    public boolean isRestrictive() {
        return restrictive;
    }

    private FolioType(boolean guestFolio, boolean restrictive) {
        this.guestFolio = guestFolio;
        this.restrictive = restrictive;
    }
}
