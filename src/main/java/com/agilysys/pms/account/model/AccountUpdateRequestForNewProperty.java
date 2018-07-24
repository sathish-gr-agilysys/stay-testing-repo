/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AccountUpdateRequestForNewProperty {
    public String tenantId;
    public String propertyId;
    public String companyProfileId;
    public boolean accountUpdateFailed;
    public boolean ratePlanUpdateFailed;

    public AccountUpdateRequestForNewProperty(String tenantId, String propertyId) {
        this.tenantId = tenantId;
        this.propertyId = propertyId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getCompanyProfileId() {
        return companyProfileId;
    }

    public void setCompanyProfileId(String companyProfileId) {
        this.companyProfileId = companyProfileId;
    }

    public boolean isAccountUpdateFailed() {
        return accountUpdateFailed;
    }

    public void setAccountUpdateFailed(boolean accountUpdateFailed) {
        this.accountUpdateFailed = accountUpdateFailed;
    }

    public boolean isRatePlanUpdateFailed() {
        return ratePlanUpdateFailed;
    }

    public void setRatePlanUpdateFailed(boolean ratePlanUpdateFailed) {
        this.ratePlanUpdateFailed = ratePlanUpdateFailed;
    }
}
