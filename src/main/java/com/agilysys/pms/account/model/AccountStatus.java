/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public enum AccountStatus {
    PENDING(true),
    OPEN(true),
    CLOSED(false);

    private boolean active;

    AccountStatus(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
