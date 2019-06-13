package com.agilysys.pms.account.model;

import java.util.Set;

import com.agilysys.pms.common.model.GeneralLedgerCodeType;

public class GlCodeTemplateRequest {
    private Set<String> buildingIds;
    private Set<String> guestTypeIds;
    private Set<String> marketSegmentIds;
    private Set<String> mealPeriodIds;
    private Set<String> outletIds;
    private Set<String> paymentIds;
    private Set<String> transactionItemIds;
    private GeneralLedgerCodeType generalLedgerType;

    public Set<String> getBuildingIds() {
        return buildingIds;
    }

    public void setBuildingIds(Set<String> buildingIds) {
        this.buildingIds = buildingIds;
    }

    public Set<String> getGuestTypeIds() {
        return guestTypeIds;
    }

    public void setGuestTypeIds(Set<String> guestTypeIds) {
        this.guestTypeIds = guestTypeIds;
    }

    public Set<String> getMarketSegmentIds() {
        return marketSegmentIds;
    }

    public void setMarketSegmentIds(Set<String> marketSegmentIds) {
        this.marketSegmentIds = marketSegmentIds;
    }

    public Set<String> getMealPeriodIds() {
        return mealPeriodIds;
    }

    public void setMealPeriodIds(Set<String> mealPeriodIds) {
        this.mealPeriodIds = mealPeriodIds;
    }

    public Set<String> getOutletIds() {
        return outletIds;
    }

    public void setOutletIds(Set<String> outletIds) {
        this.outletIds = outletIds;
    }

    public Set<String> getPaymentIds() {
        return paymentIds;
    }

    public void setPaymentIds(Set<String> paymentIds) {
        this.paymentIds = paymentIds;
    }

    public Set<String> getTransactionItemIds() {
        return transactionItemIds;
    }

    public void setTransactionItemIds(Set<String> transactionItemIds) {
        this.transactionItemIds = transactionItemIds;
    }

    public GeneralLedgerCodeType getGeneralLedgerType() {
        return generalLedgerType;
    }

    public void setGeneralLedgerType(GeneralLedgerCodeType generalLedgerType) {
        this.generalLedgerType = generalLedgerType;
    }

}
