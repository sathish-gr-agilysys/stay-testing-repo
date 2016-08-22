package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetFoliosRequest {
    private boolean groupTaxLineItems = false;
    private String transactionIds;

    @JsonProperty(required = true)
    private Integer page;

    @JsonProperty(required = true)
    private Integer size;

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

    public boolean isGroupTaxLineItems() {
        return groupTaxLineItems;
    }

    public void setGroupTaxLineItems(boolean groupTaxLineItems) {
        this.groupTaxLineItems = groupTaxLineItems;
    }

    public String getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(String transactionIds) {
        this.transactionIds = transactionIds;
    }
}
