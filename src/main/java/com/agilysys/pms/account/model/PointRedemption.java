/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.audit.annotation.AuditLabel;
import com.agilysys.pms.common.model.ObjectBase;
import com.agilysys.pms.common.model.annotation.DataPortKey;

@AuditEntity(EntityTypes.POINT_REDEMPTION)
public class PointRedemption extends ObjectBase {
    private String name;

    @DataPortKey
    @AuditLabel
    private String description;

    public PointRedemption() {}

    public PointRedemption(String id, String description, String name) {
        super();
        setId(id);
        this.description = description;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public enum RedemptionFlowType {
        MOBILE_CHECK_IN,
        CHECK_OUT,
        MANUAL
    }
}
