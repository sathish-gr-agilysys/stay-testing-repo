/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class MigrationResult {
    private String existingId;
    private String newId;
    private Status status;
    private boolean updateReferences;

    public MigrationResult(String existingId) {
        this.existingId = existingId;
    }

    public MigrationResult(String existingId, String newId, Status status, boolean updateReferences) {
        this.existingId = existingId;
        this.newId = newId;
        this.status = status;
        this.updateReferences = updateReferences;
    }

    public String getExistingId() {
        return existingId;
    }

    public void setExistingId(String existingId) {
        this.existingId = existingId;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isUpdateReferences() {
        return updateReferences;
    }

    public void setUpdateReferences(boolean updateReferences) {
        this.updateReferences = updateReferences;
    }

    public enum Status {
        OK,
        ALREADY_MIGRATED
    }
}
