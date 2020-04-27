/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationDetail {
    private String accountId;
    private String folioId;
    private String value;
    @JsonProperty(required = true)
    @NotNull
    private Integer transactionLimit;
    private Integer transactionMade;
    private Integer priority;

    public DestinationDetail(String accountId, String folioId) {
        this.accountId = accountId;
        this.folioId = folioId;
    }

    public DestinationDetail(String accountId, String folioId, String value) {
        this(accountId, folioId);
        this.value = value;
    }

    public DestinationDetail(String accountId, String folioId, String value, Integer transactionLimit, Integer priority,
          Integer transactionMade) {
        this(accountId, folioId, value);
        this.transactionLimit = transactionLimit;
        this.transactionMade = transactionMade;
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

    public Integer getTransactionMade() {
        return transactionMade;
    }

    public void setTransactionMade(Integer transactionMade) {
        this.transactionMade = transactionMade;
    }
}
