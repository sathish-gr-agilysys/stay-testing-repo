/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class RatePlan {
    private String ratePlanId;
    private boolean updateAllProperties;

    public RatePlan() {
    }

    public RatePlan(String ratePlanId, boolean updateAllProperties) {
        this.ratePlanId = ratePlanId;
        this.updateAllProperties = updateAllProperties;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public boolean isUpdateAllProperties() {
        return updateAllProperties;
    }

    public void setUpdateAllProperties(boolean updateAllProperties) {
        this.updateAllProperties = updateAllProperties;
    }
}
