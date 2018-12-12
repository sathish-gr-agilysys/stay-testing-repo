/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.pms.common.model.annotation.DataPortId;
import com.agilysys.pms.common.model.annotation.DataPortIgnore;
import com.agilysys.pms.common.model.annotation.DataPortKey;
import com.agilysys.pms.common.model.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AccountingObject implements Auditable {
    @DataPortId
    protected String id;

    @JsonProperty(required = true)
    protected String name;

    @MinLengthRestriction(2)
    @MaxLengthRestriction(25)
    @JsonProperty(required = true)
    @DataPortKey
    protected String code;

    protected boolean internal;

    @DataPortIgnore
    private String migratedId;

    protected AccountingObject() {}

    protected AccountingObject(AccountingObject accountingObjectBase) {
        code = accountingObjectBase.getCode();
        id = accountingObjectBase.getId();
        internal = accountingObjectBase.isInternal();
        name = accountingObjectBase.getName();
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

    public String getMigratedId() {
        return migratedId;
    }

    public void setMigratedId(String migratedId) {
        this.migratedId = migratedId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String entityId() {
        return id;
    }

    public abstract String getDisplayName();

    @Override
    public String getDisplayText() {
        return code;
    }
}
