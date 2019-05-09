/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.DateTime;

/**
 * Created by sulgaonkara on 10/4/16.
 */
public class InvoiceReportProgressView {
    private int totalCount;
    private int processedCount;
    private String tenantId;
    private String propertyId;
    private DateTime expiration;
    private String mutexClass;
    private String tag;
    private InvoiceReportResult result;

    public int getProcessedCount() {
        return processedCount;
    }

    public void setProcessedCount(int processedCount) {
        this.processedCount = processedCount;
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

    public DateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(DateTime expiration) {
        this.expiration = expiration;
    }

    public String getMutexClass() {
        return mutexClass;
    }

    public void setMutexClass(String mutexClass) {
        this.mutexClass = mutexClass;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public InvoiceReportResult getResult() {
        return result;
    }

    public void setResult(InvoiceReportResult result) {
        this.result = result;
    }

    public int getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
