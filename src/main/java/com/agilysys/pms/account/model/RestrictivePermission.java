/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;


public class RestrictivePermission extends AccountingObjectBase {

    String restrictivePermission;

    public String getRestrictivePermission() {
        return restrictivePermission;
    }

    public void setRestrictivePermission(String restrictivePermission) {
        this.restrictivePermission = restrictivePermission;
    }

}
