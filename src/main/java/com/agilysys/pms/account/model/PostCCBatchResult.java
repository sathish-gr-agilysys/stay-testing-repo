/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.batchdistributor.model.BatchDistributorResultBase;

public class PostCCBatchResult extends BatchDistributorResultBase {
    private String tenantId;
    private String propertyId;
    private String reservationId;

    public PostCCBatchResult(){}

    public PostCCBatchResult(String tenantId, String propertyId, String reservationId){
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.reservationId = reservationId;
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

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
