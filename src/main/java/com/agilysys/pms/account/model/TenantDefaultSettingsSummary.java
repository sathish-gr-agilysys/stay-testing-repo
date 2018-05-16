/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class TenantDefaultSettingsSummary {

    protected String id;

    protected String userId;

    protected String tenantId;

    protected String companyProfileId;

    protected CompanyProfileSettings defaultSettings;

    public TenantDefaultSettingsSummary() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getCompanyProfileId() {
        return companyProfileId;
    }

    public void setCompanyProfileId(String companyProfileId) {
        this.companyProfileId = companyProfileId;
    }

    public CompanyProfileSettings getDefaultSettings() {
        return defaultSettings;
    }

    public void setDefaultSettings(CompanyProfileSettings defaultSettings) {
        this.defaultSettings = defaultSettings;
    }
}