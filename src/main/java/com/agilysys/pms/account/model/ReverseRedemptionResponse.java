/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class ReverseRedemptionResponse {
    private String id;
    private String propertyId;
    private String tenantId;
    private String reverseRedemptionStatus;
    private List<String> transferredLedgerTransactionsIds;
    private List<ReverseRedemptionError> reverseRedemptionErrors;

    public ReverseRedemptionResponse() {
    }

    public ReverseRedemptionResponse(String id, String propertyId, String tenantId, String reverseRedemptionStatus,
          List<String> transferredLedgerTransactionsIds, List<ReverseRedemptionError> reverseRedemptionErrors) {
        this.id = id;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.reverseRedemptionStatus = reverseRedemptionStatus;
        this.transferredLedgerTransactionsIds = transferredLedgerTransactionsIds;
        this.reverseRedemptionErrors = reverseRedemptionErrors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getReverseRedemptionStatus() {
        return reverseRedemptionStatus;
    }

    public void setReverseRedemptionStatus(String reverseRedemptionStatus) {
        this.reverseRedemptionStatus = reverseRedemptionStatus;
    }

    public List<String> getTransferredLedgerTransactionsIds() {
        return transferredLedgerTransactionsIds;
    }

    public void setTransferredLedgerTransactionsIds(List<String> transferredLedgerTransactionsIds) {
        this.transferredLedgerTransactionsIds = transferredLedgerTransactionsIds;
    }

    public List<ReverseRedemptionError> getReverseRedemptionErrors() {
        return reverseRedemptionErrors;
    }

    public void setReverseRedemptionErrors(List<ReverseRedemptionError> reverseRedemptionErrors) {
        this.reverseRedemptionErrors = reverseRedemptionErrors;
    }
}
