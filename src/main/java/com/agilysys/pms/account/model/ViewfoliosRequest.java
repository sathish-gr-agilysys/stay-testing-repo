package com.agilysys.pms.account.model;


public class ViewfoliosRequest {

    private String[] transactionIds;
    private String[] parentIds;
    private int page;
    private int count;

    public String[] getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(String[] transactionIds) {
        this.transactionIds = transactionIds;
    }

    public String[] getParentIds() {
        return parentIds;
    }

    public void setParentIds(String[] parentIds) {
        this.parentIds = parentIds;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
