/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class PropertySettings {
    private String propertyId;
    private String propertyName;
    private String accountId;
    private String ratePlanId;
    private boolean propertyOverridden;
    private String accountUpdateStatus;
    private String ratePlanUpdateStatus;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public boolean isPropertyOverridden() {
        return propertyOverridden;
    }

    public void setPropertyOverridden(boolean propertyOverridden) {
        this.propertyOverridden = propertyOverridden;
    }

    public String getAccountUpdateStatus() {
        return accountUpdateStatus;
    }

    public void setAccountUpdateStatus(String accountUpdateStatus) {
        this.accountUpdateStatus = accountUpdateStatus;
    }

    public String getRatePlanUpdateStatus() {
        return ratePlanUpdateStatus;
    }

    public void setRatePlanUpdateStatus(String ratePlanUpdateStatus) {
        this.ratePlanUpdateStatus = ratePlanUpdateStatus;
    }
}
