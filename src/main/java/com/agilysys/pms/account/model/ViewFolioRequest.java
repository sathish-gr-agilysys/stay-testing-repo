package com.agilysys.pms.account.model;

/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

import java.util.Set;

public class ViewFolioRequest {

    private Set<String> transactionIds;
    private Set<String> parentIds;
    private int page;
    private int count;
    private boolean includeDetails;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isIncludeDetails() {
        return includeDetails;
    }

    public void setIncludeDetails(boolean includeDetails) {
        this.includeDetails = includeDetails;
    }
}
