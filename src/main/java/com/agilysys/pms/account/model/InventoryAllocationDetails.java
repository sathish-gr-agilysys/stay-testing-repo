/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.LocalDate;

public class InventoryAllocationDetails {
    private LocalDate itemStatusDate;
    private int availableQuantity;
    private int allocatedQuantity;
    private int inventoryQuantity;

    public InventoryAllocationDetails() {}

    public InventoryAllocationDetails(LocalDate itemStatusDate, int availableQuantity, int allocatedQuantity,
          int inventoryQuantity) {
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

    public int getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public void setAllocatedQuantity(int allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}
