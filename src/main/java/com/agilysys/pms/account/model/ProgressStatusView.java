/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import org.joda.time.DateTime;

/**
 * Used to send status of a process progress
 */

/**
 * @author sulgaonkara
 *
 */
public class ProgressStatusView {
    private int totalCount;
    private int processedCount;
    private String tenantId;
    private String propertyId;
    private DateTime expiration;
    private String mutexClass;
    private String tag;
    private RecurringChargesPostingResult result;

    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount
     *            the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return the processedCount
     */
    public int getProcessedCount() {
        return processedCount;
    }

    /**
     * @param processedCount
     *            the processedCount to set
     */
    public void setProcessedCount(int processedCount) {
        this.processedCount = processedCount;
    }

    /**
     * @return the tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId
     *            the tenantId to set
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return the propertyId
     */
    public String getPropertyId() {
        return propertyId;
    }

    /**
     * @param propertyId
     *            the propertyId to set
     */
    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return the expiration
     */
    public DateTime getExpiration() {
        return expiration;
    }

    /**
     * @param expiration
     *            the expiration to set
     */
    public void setExpiration(DateTime expiration) {
        this.expiration = expiration;
    }

    /**
     * @return the mutexClass
     */
    public String getMutexClass() {
        return mutexClass;
    }

    /**
     * @param mutexClass the mutexClass to set
     */
    public void setMutexClass(String mutexClass) {
        this.mutexClass = mutexClass;
    }

    /**
     * @return the result
     */
    public RecurringChargesPostingResult getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(RecurringChargesPostingResult result) {
        this.result = result;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

}
