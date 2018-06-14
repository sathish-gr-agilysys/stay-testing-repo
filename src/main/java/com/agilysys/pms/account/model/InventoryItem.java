/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryItem extends TransactionItem {
    private static final String DISPLAY_NAME = "Inventory item";

    @JsonProperty(required = true)
    private int availableCount;

    public InventoryItem() {

    }

    public InventoryItem(TransactionItem transactionItem, int availableCount) {
        setAvailableCount(availableCount);
        setAltSystemId(transactionItem.getAltSystemId());
        setCategoryId(transactionItem.getCategoryId());
        setCode(transactionItem.getCode());
        setDefaultPrice(transactionItem.getDefaultPrice());
        setFolioPostingCodes(transactionItem.getFolioPostingCodes());
        setGlCode(transactionItem.getGlCode());
        setId(transactionItem.getId());
        setInternal(transactionItem.isInternal());
        setName(transactionItem.getName());
        setPlu(transactionItem.getPlu());
        setSourceMealPeriods(transactionItem.getSourceMealPeriods());
        setStatus(transactionItem.getStatus());
        setSubcategoryId(transactionItem.getSubcategoryId());
        setRoomRevenue(transactionItem.isRoomRevenue());
        setTaxClasses(transactionItem.getTaxClasses());
    }

    public TransactionItemType getType() {
        return TransactionItemType.INVENTORY;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, Boolean.FALSE);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, Boolean.FALSE);
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
