/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import org.apache.commons.lang3.StringUtils;

import com.agilysys.pms.maintenance.domain.JobDetail.Status;

/**
 * Detailed Property Settings model for representing the Tenant AR View
 *
 * @see <a
 * href="">http://confluence.bellevue.ad.local:8090/display/VICTRIAL/Account+Document</a>
 */
public class TenantARPropertySettingStatus {

    public static final String YES = "Yes";
    public static final String NO = "No";
    private String propertyId;
    private String propertyName;
    private String propertyCode;
    private String accountId;
    private String ratePlanId;
    private String propertyOverridden;
    private Status accountUpdateStatus;
    private Status ratePlanUpdateStatus;

    public TenantARPropertySettingStatus() {
    }

    public TenantARPropertySettingStatus(String propertyId, String propertyName, String propertyCode) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.propertyCode = propertyCode;
    }

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

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getAccountId() {
        return trimToEmpty(accountId);
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRatePlanId() {
        return trimToEmpty(ratePlanId);
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getPropertyOverridden() {
        return trimToEmpty(propertyOverridden);
    }

    public void setPropertyOverridden(String propertyOverridden) {
        this.propertyOverridden = propertyOverridden;
    }

    public Status getAccountUpdateStatus() {
        return accountUpdateStatus;
    }

    public void setAccountUpdateStatus(Status accountUpdateStatus) {
        this.accountUpdateStatus = accountUpdateStatus;
    }

    public Status getRatePlanUpdateStatus() {
        return ratePlanUpdateStatus;
    }

    public void setRatePlanUpdateStatus(Status ratePlanUpdateStatus) {
        this.ratePlanUpdateStatus = ratePlanUpdateStatus;
    }
}
