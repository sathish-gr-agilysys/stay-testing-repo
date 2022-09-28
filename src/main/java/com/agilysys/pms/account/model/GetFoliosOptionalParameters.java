package com.agilysys.pms.account.model;

public class GetFoliosOptionalParameters {
    private boolean groupTaxLineItems = false;
    private String transactionIds;
    private boolean includePackageFolio;
    private boolean excludeNonGuestFolio;

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

    public boolean isIncludePackageFolio() {
        return includePackageFolio;
    }

    public void setIncludePackageFolio(boolean includePackageFolio) {
        this.includePackageFolio = includePackageFolio;
    }

    public boolean isExcludeNonGuestFolio() {
        return excludeNonGuestFolio;
    }

    public void setExcludeNonGuestFolio(boolean excludeNonGuestFolio) {
        this.excludeNonGuestFolio = excludeNonGuestFolio;
    }
}
