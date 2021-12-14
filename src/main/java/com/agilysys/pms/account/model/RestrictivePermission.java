/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.security.Permission;

@AuditEntity(EntityTypes.RESTRICTIVE_PERMISSION)
public class RestrictivePermission extends AccountingObjectBase {
    private static final String DISPLAY_NAME = "Restrictive Permission";

    private Permission restrictivePermission;

    public Permission getRestrictivePermission() {
        return restrictivePermission;
    }

    public void setRestrictivePermission(Permission restrictivePermission) {
        this.restrictivePermission = restrictivePermission;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}