package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.AllowanceCombination;

public class PackageLineItemsRequest {
    List<AllowanceCombination> allowanceCombination;
    LocalDate endDate;
    String packageFolioId;
    String propertyId;
    LocalDate startDate;
    String tenantId;

    public PackageLineItemsRequest() {}

    public PackageLineItemsRequest(List<AllowanceCombination> allowanceCombination, String packageFolioId,
          String propertyId, String tenantId) {
        this.allowanceCombination = allowanceCombination;
        this.packageFolioId = packageFolioId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
    }

    public List<AllowanceCombination> getAllowanceCombination() {
        return allowanceCombination;
    }

    public void setAllowanceCombination(List<AllowanceCombination> allowanceCombination) {
        this.allowanceCombination = allowanceCombination;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPackageFolioId() {
        return packageFolioId;
    }

    public void setPackageFolioId(String packageFolioId) {
        this.packageFolioId = packageFolioId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}