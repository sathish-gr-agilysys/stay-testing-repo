package com.agilysys.pms.account.model;

public class GetFoliosOptionalParameters {
    private boolean groupTaxLineItems = false;
    private String transactionIds;
    private boolean includePackageFolio;
    private boolean includeThirdPartyFolio;

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

    public boolean isIncludeThirdPartyFolio() {
        return includeThirdPartyFolio;
    }

    public void setIncludeThirdPartyFolio(boolean includeThirdPartyFolio) {
        this.includeThirdPartyFolio = includeThirdPartyFolio;
    }
}
