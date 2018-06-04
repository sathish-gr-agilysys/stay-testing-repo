/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class RatePlan {
    private String ratePlanId;
    private boolean updateExistingProperty;

    public RatePlan() {
    }

    public RatePlan(String ratePlanId, boolean updateExistingProperty) {
        this.ratePlanId = ratePlanId;
        this.updateExistingProperty = updateExistingProperty;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public boolean isUpdateExistingProperty() {
        return updateExistingProperty;
    }

    public void setUpdateExistingProperty(boolean updateExistingProperty) {
        this.updateExistingProperty = updateExistingProperty;
    }
}
