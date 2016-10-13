package com.agilysys.pms.account.model;

/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewFolioRequest {

    private Set<String> transactionIds;
    private Set<String> parentIds;
    @JsonProperty(required = true)
    private Integer page;
    @JsonProperty(required = true)
    private Integer size;
    private boolean includeDetails;

    public Set<String> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(Set<String> transactionIds) {
        this.transactionIds = transactionIds;
    }

    public Set<String> getParentIds() {
        return parentIds;
    }

    public void setParentIds(Set<String> parentIds) {
        this.parentIds = parentIds;
    }

    public boolean isIncludeDetails() {
        return includeDetails;
    }

    public void setIncludeDetails(boolean includeDetails) {
        this.includeDetails = includeDetails;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
