/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public class ARBalanceInfo {
    private String tenantId;
    private List<String> ageGroupLabels;
    private List<CompanyBalanceInfo> companyProfiles;

    private Map<String, LocalDate> propertyDateMap;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<String> getAgeGroupLabels() {
        return ageGroupLabels;
    }

    public void setAgeGroupLabels(List<String> ageGroupLabels) {
        this.ageGroupLabels = ageGroupLabels;
    }

    public List<CompanyBalanceInfo> getCompanyProfiles() {
        return companyProfiles;
    }

    public void setCompanyProfiles(List<CompanyBalanceInfo> companyProfiles) {
        this.companyProfiles = companyProfiles;
    }

    public Map<String, LocalDate> getPropertyDateMap() {
        return propertyDateMap;
    }

    public void setPropertyDateMap(Map<String, LocalDate> propertyDateMap) {
        this.propertyDateMap = propertyDateMap;
    }
}