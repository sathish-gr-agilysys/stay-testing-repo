/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.agilysys.pms.common.secondarywrites.SecondaryWritable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents a TransactionSubCategory in the application.
 */
@AuditEntity(EntityTypes.TRANSACTION_SUBCATEGORY)
public class TransactionSubCategory extends AccountingObjectBase implements SecondaryWritable<String> {

    private static final String DISPLAY_NAME = "Transaction subcategory";

    public static final String TAX_SUBCATEGORY_ID = "4de2420a-80cb-440f-999b-f6908325ffde";

    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    @DataPortReference(name = "categoryCodes", type = TransactionCategory.class, multiple = true)
    @AuditField(name = "categories", references = EntityTypes.TRANSACTION_CATEGORY, inline = true)
    private List<String> categoryIds;

    /**
     * @return the categoryIds
     */
    public List<String> getCategoryIds() {
        return categoryIds;
    }

    /**
     * @param categoryIds the categoryIds to set
     */
    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
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

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
