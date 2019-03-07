/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class FolioInvoiceRequest {

    private String accountId;
    private String reservationId;
    private boolean includeDetails;
    private List<String> folioIds;
    private List<String> transactionIds;
    private List<String> parentIds;
    private List<String> summaryTransactionIds;
    private List<String> detailTransactionIds;
    private List<String> summaryParentIds;
    private List<String> detailParentIds;

    public FolioInvoiceRequest() {
    }

    public FolioInvoiceRequest(String accountId, List<String> folioIds) {
        this.accountId = accountId;
        this.folioIds = folioIds;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<String> getFolioIds() {
        return folioIds;
    }

    public void setFolioIds(List<String> folioIds) {
        this.folioIds = folioIds;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isIncludeDetails() {
        return includeDetails;
    }

    public void setIncludeDetails(boolean includeDetails) {
        this.includeDetails = includeDetails;
    }

    public List<String> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(List<String> transactionIds) {
        this.transactionIds = transactionIds;
    }

    public List<String> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<String> parentIds) {
        this.parentIds = parentIds;
    }

    public List<String> getSummaryTransactionIds() {
        return summaryTransactionIds;
    }

    public void setSummaryTransactionIds(List<String> summaryTransactionIds) {
        this.summaryTransactionIds = summaryTransactionIds;
    }

    public List<String> getDetailTransactionIds() {
        return detailTransactionIds;
    }

    public void setDetailTransactionIds(List<String> detailTransactionIds) {
        this.detailTransactionIds = detailTransactionIds;
    }

    public List<String> getSummaryParentIds() {
        return summaryParentIds;
    }

    public void setSummaryParentIds(List<String> summaryParentIds) {
        this.summaryParentIds = summaryParentIds;
    }

    public List<String> getDetailParentIds() {
        return detailParentIds;
    }

    public void setDetailParentIds(List<String> detailParentIds) {
        this.detailParentIds = detailParentIds;
    }
}
