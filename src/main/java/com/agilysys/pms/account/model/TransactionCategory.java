/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.property.model.Building;
import com.agilysys.pms.property.model.Outlet;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents a TransactionCategory in the application.
 */
public class TransactionCategory extends AccountingObjectBase {
    public static final String TAX_CATEGORY_ID = "5dd994cf-6aa4-4040-9adb-38a59297ccab";

    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    @DataPortReference(name = "sourceCodes", type = { Building.class, Outlet.class }, multiple = true)
    private List<String> sourceIds;

    @JsonProperty(required = true)
    @DataPortReference(name = "defaultSourceCode", type = { Building.class, Outlet.class })
    private String defaultSourceId;

    /**
     * @return the sourceIds
     */
    public List<String> getSourceIds() {
        return sourceIds;
    }

    /**
     * @param sourceIds the sourceIds to set
     */
    public void setSourceIds(List<String> sourceIds) {
        this.sourceIds = sourceIds;
    }

    public String getDefaultSourceId() {
        return defaultSourceId;
    }

    public void setDefaultSourceId(String defaultSourceId) {
        this.defaultSourceId = defaultSourceId;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj, Boolean.FALSE);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this, Boolean.FALSE);
    }
}
