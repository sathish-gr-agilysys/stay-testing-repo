/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class InventoryAllocationDetails {
    private LocalDate itemStatusDate;
    private long allocatedQuantity;
    private int availableQuantity;
    private Integer inventoryQuantity;

    public InventoryAllocationDetails() {}

    public InventoryAllocationDetails(LocalDate itemStatusDate, int availableQuantity, long allocatedQuantity,
          Integer inventoryQuantity) {
        this.itemStatusDate = itemStatusDate;
        this.availableQuantity = availableQuantity;
        this.allocatedQuantity = allocatedQuantity;
        this.inventoryQuantity = inventoryQuantity;
    }

    public LocalDate getItemStatusDate() {
        return itemStatusDate;
    }

    public void setItemStatusDate(LocalDate itemStatusDate) {
        this.itemStatusDate = itemStatusDate;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public long getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public void setAllocatedQuantity(long allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public boolean isInventoryUnrestricted() {
        return inventoryQuantity == null;
    }
}
