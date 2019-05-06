/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class FolioInvoiceRequest {

    private List<String> accountIds;
    private List<String> folioIds;
    private List<String> transactionIds;
    private List<String> parentIds;
    private List<String> summaryTransactionIds;
    private List<String> detailTransactionIds;
    private List<String> summaryParentIds;
    private List<String> detailParentIds;
    private Map<String, List<String>> folioIdsByAccountId;

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public List<String> getFolioIds() {
        return folioIds;
    }

    public void setFolioIds(List<String> folioIds) {
        this.folioIds = folioIds;
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

    public Map<String, List<String>> getFolioIdsByAccountId() {
        return folioIdsByAccountId;
    }

    public void setFolioIdsByAccountId(Map<String, List<String>> folioIdsByAccountId) {
        this.folioIdsByAccountId = folioIdsByAccountId;
    }
}
