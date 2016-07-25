/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains fields every item must have
 */
public abstract class AccountingItem extends AccountingObjectBase {
    @JsonProperty(required = true)
    @DataPortReference(name = "categoryCode", type = TransactionCategory.class)
    protected String categoryId;

    @JsonProperty(required = true)
    @DataPortReference(name = "subcategoryCode", type = TransactionSubCategory.class)
    protected String subcategoryId;

    /**
     * Flag that denotes whether or not the item should be classified as room revenue when posted as a transaction.
     */
    private boolean roomRevenue;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public boolean isRoomRevenue() {
        return roomRevenue;
    }

    public void setRoomRevenue(boolean roomRevenue) {
        this.roomRevenue = roomRevenue;
    }
}
