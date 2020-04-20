/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class DestinationDetail {
    private String accountId;
    private String folioId;
    private String value;
    private Integer transactionLimit;
    private Integer priority;

    public DestinationDetail(String accountId, String folioId) {
        this.accountId = accountId;
        this.folioId = folioId;
    }

    public DestinationDetail(String accountId, String folioId, String value) {
        this(accountId, folioId);
        this.value = value;
    }

    public DestinationDetail(String accountId, String folioId, String value, Integer transactionLimit, Integer priority) {
        this(accountId, folioId, value);
        this.transactionLimit = transactionLimit;
        this.priority = priority;
    }

    public DestinationDetail() {}

    public String getAccountId() { return accountId; }

    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getFolioId() { return folioId; }

    public void setFolioId(String folioId) { this.folioId = folioId; }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }

    public Integer getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Integer transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
