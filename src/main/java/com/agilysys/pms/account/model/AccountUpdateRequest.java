/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Collection;

public class AccountUpdateRequest {
    public static final String TYPE_AR_APPLY = "ARApply";

    private final String type;
    private String companyProfileId;
    private String requestId;
    private Collection<String> propertyIds;

    public AccountUpdateRequest(String type) {
        this.type = type;
    }

    public AccountUpdateRequest(String type, String companyProfileId, String requestId) {
        this(type);
        this.companyProfileId = companyProfileId;
        this.requestId = requestId;
    }

    public AccountUpdateRequest(String type, String companyProfileId, String requestId, Collection<String> propertyIds)
    {
        this(type, companyProfileId, requestId);
        this.propertyIds = propertyIds;
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

    public Collection<String> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(Collection<String> propertyIds) {
        this.propertyIds = propertyIds;
    }
}
