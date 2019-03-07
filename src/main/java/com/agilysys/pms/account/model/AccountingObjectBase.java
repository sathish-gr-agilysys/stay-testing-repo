/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.audit.annotation.AuditIgnoreDefault;
import com.agilysys.pms.common.audit.annotation.AuditLabel;
import com.agilysys.pms.common.model.annotation.DataPortId;
import com.agilysys.pms.common.model.annotation.DataPortIgnore;
import com.agilysys.pms.common.model.annotation.DataPortKey;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AccountingObjectBase {
    @DataPortId
    @AuditField(id = true, ignore = true)
    protected String id;

    @JsonProperty(required = true)
    protected String name;

    @MinLengthRestriction(2)
    @MaxLengthRestriction(25)
    @JsonProperty(required = true)
    @DataPortKey
    @AuditLabel
    protected String code;

    @AuditIgnoreDefault
    protected boolean internal;

    @DataPortIgnore
    private Boolean migrated;

    public abstract String getDisplayName();

    protected AccountingObjectBase() {}

    protected AccountingObjectBase(AccountingObjectBase accountingObjectBaseBase) {
        code = accountingObjectBaseBase.getCode();
        id = accountingObjectBaseBase.getId();
        internal = accountingObjectBaseBase.isInternal();
        name = accountingObjectBaseBase.getName();
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public boolean isInternal()
    {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public Boolean isMigrated() {
        return migrated;
    }

    public void setMigrated(Boolean migrated) {
        this.migrated = migrated;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
