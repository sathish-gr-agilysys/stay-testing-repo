/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import com.agilysys.pms.account.exception.ReverseRedemptionError;

public class ReverseRedemptionResponse {
    private String id;
    private String propertyId;
    private String tenantId;
    private String reverseRedemptionStatus;
    private List<String> transferredLedgerTransactionsIds;
    private List<ReverseRedemptionError> reverseRedemptionErrors;
    Map<String, ReverseRedemptionError> failedTransactionIdWithError;
    private List<String> transactionIds;

    public ReverseRedemptionResponse() {
    }

    public ReverseRedemptionResponse(String id, String propertyId, String tenantId, String reverseRedemptionStatus,
          List<String> transferredLedgerTransactionsIds, List<ReverseRedemptionError> reverseRedemptionErrors,
          List<String> transactionIds, Map<String, ReverseRedemptionError> failedTransactionIdWithError) {
        this.id = id;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.reverseRedemptionStatus = reverseRedemptionStatus;
        this.transferredLedgerTransactionsIds = transferredLedgerTransactionsIds;
        this.reverseRedemptionErrors = reverseRedemptionErrors;
        this.failedTransactionIdWithError = failedTransactionIdWithError;
        this.transactionIds = transactionIds;
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

    public Map<String, ReverseRedemptionError> getFailedTransactionIdWithError() {
        return failedTransactionIdWithError;
    }

    public void setFailedTransactionIdWithError(Map<String, ReverseRedemptionError> failedTransactionIdWithError) {
        this.failedTransactionIdWithError = failedTransactionIdWithError;
    }

    public List<String> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(List<String> transactionIds) {
        this.transactionIds = transactionIds;
    }
}
