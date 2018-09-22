/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntityType;
import com.fasterxml.jackson.annotation.JsonProperty;

@AuditEntityType(EntityTypes.INVENTORY_ITEM)
public class InventoryItem extends TransactionItem {
    private static final String DISPLAY_NAME = "Inventory item";

    @JsonProperty(required = true)
    private int availableCount;

    public InventoryItem() {}

    public InventoryItem(TransactionItem transactionItem, int availableCount, CanonicalId status) {
        super(transactionItem);

        setAvailableCount(availableCount);
        setStatus(status);
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
