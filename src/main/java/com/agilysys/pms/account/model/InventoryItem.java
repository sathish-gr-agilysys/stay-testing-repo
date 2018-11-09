/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@AuditEntityType(EntityTypes.INVENTORY_ITEM)
public class InventoryItem extends TransactionItem {
    private static final String DISPLAY_NAME = "Inventory item";

    private Integer availableCount;

    private Integer maxQuantityPerReservation;

    private Set<String> restrictedRoomTypes;

    public InventoryItem() {
        restrictedRoomTypes = new LinkedHashSet<>();
    }

    public InventoryItem(TransactionItem transactionItem, Integer availableCount, CanonicalId status) {
        super(transactionItem);

        setStatus(status);
        this.availableCount = availableCount;
    }

    public InventoryItem(TransactionItem transactionItem, Integer availableCount, CanonicalId status,
          Integer maxQuantityPerReservation, Set<String> restrictedRoomTypes) {
        super(transactionItem);

        setStatus(status);
        this.availableCount = availableCount;
        this.maxQuantityPerReservation = maxQuantityPerReservation;
        this.restrictedRoomTypes = restrictedRoomTypes;
    }

    public TransactionItemType getType() {
        return TransactionItemType.INVENTORY;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getMaxQuantityPerReservation() {
        return maxQuantityPerReservation;
    }

    public void setMaxQuantityPerReservation(Integer maxQuantityPerReservation) {
        this.maxQuantityPerReservation = maxQuantityPerReservation;
    }

    public Set<String> getRestrictedRoomTypes() {
        return restrictedRoomTypes;
    }

    public void setRestrictedRoomTypes(Set<String> restrictedRoomTypes) {
        this.restrictedRoomTypes = restrictedRoomTypes;
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
    
    @JsonIgnore
    public boolean isRoomTypeRestricted(String roomTypeId) {
        if (restrictedRoomTypes != null) {
            return restrictedRoomTypes.contains(roomTypeId);
        }

        return false;
    }

    @JsonIgnore
    public boolean isMaxPerReservationRestricted(int quantity) {
        return maxQuantityPerReservation != null && maxQuantityPerReservation < quantity;
    }
}
