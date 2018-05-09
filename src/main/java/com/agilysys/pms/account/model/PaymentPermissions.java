/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentPermissions extends AccountingObjectBase {

    String restrictivePermissions;

    public String getRestrictivePermissions() {
        return restrictivePermissions;
    }

    public void setRestrictivePermissions(String restrictivePermissions) {
        this.restrictivePermissions = restrictivePermissions;
    }

}
