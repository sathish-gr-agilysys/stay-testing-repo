/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryItem extends TransactionItem {
    @JsonProperty(required = true)
    private int availableCount;

    @Transient
    private TransactionItemType type = TransactionItemType.Inventory;

    public TransactionItemType getType() {
        return type;
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
}
