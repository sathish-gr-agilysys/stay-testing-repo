/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class MigrationResult {
    private String itemId;
    private String newItemId;
    private Status status;
    private boolean updateReference;

    public MigrationResult(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getNewItemId() {
        return newItemId;
    }

    public void setNewItemId(String newItemId) {
        this.newItemId = newItemId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isUpdateReference() {
        return updateReference;
    }

    public void setUpdateReference(boolean updateReference) {
        this.updateReference = updateReference;
    }

    public enum Status {
        OK,
        ALREADY_MIGRATED
    }
}
