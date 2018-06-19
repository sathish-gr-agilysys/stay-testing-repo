/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AccountSettings {
    private boolean createOnNewProperty;
    private boolean createOnMissingProperty;
    private boolean updateExistingProperty;
    private boolean keepAccountNumber;
    private String preferredAccountNumber;
    private AccountAttributes attributes;

    public AccountSettings() {
    }

    public AccountSettings(boolean createOnNewProperty, boolean createOnMissingProperty, boolean updateExistingProperty,
          boolean keepAccountNumber, String preferredAccountNumber, AccountAttributes attributes) {
        this.createOnNewProperty = createOnNewProperty;
        this.createOnMissingProperty = createOnMissingProperty;
        this.updateExistingProperty = updateExistingProperty;
        this.keepAccountNumber = keepAccountNumber;
        this.preferredAccountNumber = preferredAccountNumber;
        this.attributes = attributes;
    }

    public boolean isCreateOnNewProperty() {
        return createOnNewProperty;
    }

    public void setCreateOnNewProperty(boolean createOnNewProperty) {
        this.createOnNewProperty = createOnNewProperty;
    }

    public boolean isCreateOnMissingProperty() {
        return createOnMissingProperty;
    }

    public void setCreateOnMissingProperty(boolean createOnMissingProperty) {
        this.createOnMissingProperty = createOnMissingProperty;
    }

    public boolean isUpdateExistingProperty() {
        return updateExistingProperty;
    }

    public void setUpdateExistingProperty(boolean updateExistingProperty) {
        this.updateExistingProperty = updateExistingProperty;
    }

    public boolean isKeepAccountNumber() {
        return keepAccountNumber;
    }

    public void setKeepAccountNumber(boolean keepAccountNumber) {
        this.keepAccountNumber = keepAccountNumber;
    }

    public String getPreferredAccountNumber() {
        return preferredAccountNumber;
    }

    public void setPreferredAccountNumber(String preferredAccountNumber) {
        this.preferredAccountNumber = preferredAccountNumber;
    }

    public AccountAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(AccountAttributes attributes) {
        this.attributes = attributes;
    }
}
