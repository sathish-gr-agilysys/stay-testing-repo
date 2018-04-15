/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Transient;

import com.agilysys.pms.common.model.annotation.DataPortIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryItem extends TransactionItem {
    private static final String DISPLAY_NAME = "Inventory item";

    @JsonProperty(required = true)
    private int availableCount;

    /*
    If the inventory item is converted from transaction item
    then this field has the converted time
     */
    @DataPortIgnore
    private DateTime convertedTime;

    public DateTime getConvertedTime() {
        return convertedTime;
    }

    public void setConvertedTime(DateTime convertedTime) {
        this.convertedTime = convertedTime;
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
