/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigInteger;

import org.joda.time.LocalDate;

public class InventoryAllocationDetails {
    private LocalDate itemStatusDate;
    private BigInteger allocatedQuantity;
    private int availableQuantity;
    private int inventoryQuantity;

    public InventoryAllocationDetails() {}

    public InventoryAllocationDetails(LocalDate itemStatusDate, int availableQuantity, BigInteger allocatedQuantity,
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

    public BigInteger getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public void setAllocatedQuantity(BigInteger allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}
