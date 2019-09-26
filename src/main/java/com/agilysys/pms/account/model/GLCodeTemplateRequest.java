/*
 * Copyright (c) 2019. Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

import com.agilysys.pms.common.model.GeneralLedgerCodeType;

public class GLCodeTemplateRequest {
    private Set<String> buildingIds;
    private Set<String> guestTypeIds;
    private Set<String> marketSegmentIds;
    private Set<String> mealPeriodIds;
    private Set<String> outletIds;
    private Set<String> paymentMethodIds;
    private Set<String> transactionItemIds;
    private GeneralLedgerCodeType generalLedgerCodeType;

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

    public Set<String> getPaymentMethodIds() {
        return paymentMethodIds;
    }

    public void setPaymentMethodIds(Set<String> paymentMethodIds) {
        this.paymentMethodIds = paymentMethodIds;
    }

    public Set<String> getTransactionItemIds() {
        return transactionItemIds;
    }

    public void setTransactionItemIds(Set<String> transactionItemIds) {
        this.transactionItemIds = transactionItemIds;
    }

    public GeneralLedgerCodeType getGeneralLedgerCodeType() {
        return generalLedgerCodeType;
    }

    public void setGeneralLedgerCodeType(GeneralLedgerCodeType generalLedgerCodeType) {
        this.generalLedgerCodeType = generalLedgerCodeType;
    }

}
