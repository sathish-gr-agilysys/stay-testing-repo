/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model;

import java.util.Set;

public class AccountUpdateRequest {
    public static final String TYPE_AR_APPLY = "AR Apply";

    private final String type;
    private String companyProfileId;
    private String requestId;
    private Set<String> propertyIds;

    public AccountUpdateRequest(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String getCompanyProfileId() {
        return companyProfileId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setCompanyProfileId(String companyProfileId) {
        this.companyProfileId = companyProfileId;
    }

    public Set<String> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(Set<String> propertyIds) {
        this.propertyIds = propertyIds;
    }
}
