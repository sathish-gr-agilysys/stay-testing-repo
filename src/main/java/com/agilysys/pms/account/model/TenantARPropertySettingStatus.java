/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import org.springframework.data.annotation.Transient;

import com.agilysys.pms.maintenance.domain.JobDetail;
import com.agilysys.pms.maintenance.domain.JobDetail.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Detailed Property Settings model for representing the Tenant AR View
 *
 * @see <a
 * href="">http://confluence.bellevue.ad.local:8090/display/VICTRIAL/Account+Document</a>
 */
public class TenantARPropertySettingStatus {

    public static final String PROPERTY_OVERRIDDEN_YES = "Yes";
    public static final String PROPERTY_OVERRIDDEN_NO = "No";

    @Transient
    @JsonIgnore
    private String accountContactId;
    @Transient
    @JsonIgnore
    private String accountId;
    private String accountNumber;
    private Status accountUpdateStatus = JobDetail.Status.SUCCEEDED;
    private String propertyCode;
    @Transient
    @JsonIgnore
    private String propertyId;
    private String propertyName;
    private String propertyOverridden = TenantARPropertySettingStatus.PROPERTY_OVERRIDDEN_NO;
    @Transient
    @JsonIgnore
    private String ratePlanId;
    private String ratePlanName;
    private Status ratePlanUpdateStatus = JobDetail.Status.SUCCEEDED;

    public TenantARPropertySettingStatus() {
    }

    public TenantARPropertySettingStatus(String propertyId, String propertyName, String propertyCode) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.propertyCode = propertyCode;
    }

    public String getAccountContactId() {
        return trimToEmpty(accountContactId);
    }

    public void setAccountContactId(String accountContactId) {
        this.accountContactId = accountContactId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return trimToEmpty(accountNumber);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Status getAccountUpdateStatus() {
        return accountUpdateStatus;
    }

    public void setAccountUpdateStatus(Status accountUpdateStatus) {
        this.accountUpdateStatus = accountUpdateStatus;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return trimToEmpty(propertyName);
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyOverridden() {
        return trimToEmpty(propertyOverridden);
    }

    public void setPropertyOverridden(String propertyOverridden) {
        this.propertyOverridden = propertyOverridden;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getRatePlanName() {
        return trimToEmpty(ratePlanName);
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public Status getRatePlanUpdateStatus() {
        return ratePlanUpdateStatus;
    }

    public void setRatePlanUpdateStatus(Status ratePlanUpdateStatus) {
        this.ratePlanUpdateStatus = ratePlanUpdateStatus;
    }
}
