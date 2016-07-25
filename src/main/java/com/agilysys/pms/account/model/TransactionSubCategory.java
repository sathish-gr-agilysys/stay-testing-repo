/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents a TransactionSubCategory in the application.
 */
public class TransactionSubCategory extends AccountingObjectBase {
    public static final String TAX_SUBCATEGORY_ID = "4de2420a-80cb-440f-999b-f6908325ffde";

    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    @DataPortReference(name = "categoryCodes", type = TransactionCategory.class, multiple = true)
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
}
