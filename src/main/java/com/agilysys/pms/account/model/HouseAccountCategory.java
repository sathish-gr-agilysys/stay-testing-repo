/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.springframework.validation.annotation.Validated;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
public class HouseAccountCategory extends AccountingObjectBase {
    @MaxLengthRestriction(3)
    private String prefix;

    @MaxLengthRestriction(3)
    private String suffix;

    @JsonProperty(required = true)
    private boolean active;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
