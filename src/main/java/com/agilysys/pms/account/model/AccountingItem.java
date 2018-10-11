/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntityType;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains fields every item must have
 */
public abstract class AccountingItem extends AccountingObjectBase {
    @JsonProperty(required = true)
    @DataPortReference(name = "categoryCode", type = TransactionCategory.class)
    @AuditField(name = "category", references = EntityTypes.TRANSACTION_CATEGORY)
    protected String categoryId;

    @JsonProperty(required = true)
    @DataPortReference(name = "subcategoryCode", type = TransactionSubCategory.class)
    @AuditField(name = "subcategory", references = EntityTypes.TRANSACTION_SUBCATEGORY)
    protected String subcategoryId;

    /**
     * Flag that denotes whether or not the item should be classified as room revenue when posted as a transaction.
     */
    private boolean roomRevenue;

    public AccountingItem(){}

    public AccountingItem(AccountingItem accountingItem) {
        super(accountingItem);

        categoryId = accountingItem.getCategoryId();
        subcategoryId = accountingItem.getSubcategoryId();
        roomRevenue = accountingItem.isRoomRevenue();
    }

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
