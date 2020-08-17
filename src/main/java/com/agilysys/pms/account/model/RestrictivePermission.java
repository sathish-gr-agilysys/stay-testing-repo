/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.common.permission.PermissionType;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;

@AuditEntity(EntityTypes.RESTRICTIVE_PERMISSION)
public class RestrictivePermission extends AccountingObjectBase {
    private static final String DISPLAY_NAME = "Restrictive Permission";

    private PermissionType restrictivePermission;

    public PermissionType getRestrictivePermission() {
        return restrictivePermission;
    }

    public void setRestrictivePermission(PermissionType restrictivePermission) {
        this.restrictivePermission = restrictivePermission;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

}
