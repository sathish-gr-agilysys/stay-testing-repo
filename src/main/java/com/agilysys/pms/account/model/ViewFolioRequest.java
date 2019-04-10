package com.agilysys.pms.account.model;

/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.data.domain.Sort.Direction;

public class ViewFolioRequest {

    private Set<String> transactionIds;
    private Set<String> parentIds;
    private Integer page;
    private Integer size;
    private String parentSortOrder = Direction.DESC.name();
    private String childrenSortOrder = Direction.ASC.name();
    private DateTime timeStamp;
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

    public DateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(DateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getParentSortOrder() {
        return parentSortOrder;
    }

    public void setParentSortOrder(String parentSortOrder) {
        this.parentSortOrder = parentSortOrder;
    }

    public String getChildrenSortOrder() {
        return childrenSortOrder;
    }

    public void setChildrenSortOrder(String childrenSortOrder) {
        this.childrenSortOrder = childrenSortOrder;
    }
}
