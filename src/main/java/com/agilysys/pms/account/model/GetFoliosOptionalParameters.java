package com.agilysys.pms.account.model;

public class GetFoliosOptionalParameters {
    private boolean groupTaxLineItems = false;
    private String transactionIds;
    private boolean excludePackageFolio;

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

    public boolean isExcludePackageFolio() {
        return excludePackageFolio;
    }

    public void setExcludePackageFolio(boolean excludePackageFolio) {
        this.excludePackageFolio = excludePackageFolio;
    }
}
