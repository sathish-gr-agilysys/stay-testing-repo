/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import java.util.List;

import org.joda.time.DateTime;

import com.agilysys.pms.common.model.annotation.export.ReportingExport;
import com.agilysys.pms.common.model.annotation.export.ReportingExportId;
import com.agilysys.pms.common.model.annotation.export.ReportingExportRef;
import com.agilysys.pms.common.model.export.ExportDB;
import com.agilysys.pms.common.model.export.ExportRef;

@ReportingExport(type = ExportRef.ACCOUNTS)
public class AccountExport {
    private List<FolioDetailExport> foliosDetail;
    @ReportingExportId
    private String id;
    private Long version;
    private DateTime createTime;
    private DateTime updateTime;

    @ReportingExportRef(ref = ExportRef.TENANT, db = ExportDB.RGUEST_STAY)
    private String tenantId;
    @ReportingExportRef(ref = ExportRef.PMS_PROPERTIES, db = ExportDB.RGUEST_STAY)
    private String propertyId;
    private String accountStatus;
    private String accountType;
    private String referenceId;
    private String groupAccountId;
    private String companyProfileId;
    private boolean locked;
    private String userId;
    private TaxExemptSettingsExport taxExemptSettings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
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

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getGroupAccountId() {
        return groupAccountId;
    }

    public void setGroupAccountId(String groupAccountId) {
        this.groupAccountId = groupAccountId;
    }

    public String getCompanyProfileId() {
        return companyProfileId;
    }

    public void setCompanyProfileId(String companyProfileId) {
        this.companyProfileId = companyProfileId;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TaxExemptSettingsExport getTaxExemptSettings() {
        return taxExemptSettings;
    }

    public void setTaxExemptSettings(TaxExemptSettingsExport taxExemptSettings) {
        this.taxExemptSettings = taxExemptSettings;
    }

    public List<FolioDetailExport> getFoliosDetail() {
        return foliosDetail;
    }

    public void setFoliosDetail(List<FolioDetailExport> foliosDetail) {
        this.foliosDetail = foliosDetail;
    }

}