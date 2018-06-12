/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;


public class RestrictivePermission extends AccountingObjectBase {

    private static final String DISPLAY_NAME = "Restrictive Permission";

    String restrictivePermission;

    public String getRestrictivePermission() {
        return restrictivePermission;
    }

    public void setRestrictivePermission(String restrictivePermission) {
        this.restrictivePermission = restrictivePermission;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

}
