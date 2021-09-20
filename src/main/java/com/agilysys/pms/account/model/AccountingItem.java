/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.audit.annotation.AuditIgnoreDefault;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AccountingItem extends AccountingObjectBase {
    @JsonProperty(required = true)
    @DataPortReference(name = "categoryCode", type = TransactionCategory.class)
    @AuditField(name = "category", references = EntityTypes.TRANSACTION_CATEGORY)
    protected String categoryId;

    @AuditIgnoreDefault
    protected boolean roomRevenue;

    @JsonProperty(required = true)
    @DataPortReference(name = "subcategoryCode", type = TransactionSubCategory.class)
    @AuditField(name = "subcategory", references = EntityTypes.TRANSACTION_SUBCATEGORY)
    protected String subcategoryId;

    protected AccountingItem() {
        super();
    }    
    
    protected AccountingItem(AccountingItem accountingItem) {
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
