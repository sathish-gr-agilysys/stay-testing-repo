/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.agilysys.common.model.rate.ComponentRateSnapshot;

public class ComponentChargeView {

    private String componentBundleId;

    private String transactionItemId;

    private String transactionItemName;

    private FrequencyType frequencyType;

    private BigDecimal amount;

    private int quantity;

    ChargeTaxAmountInfo estimatedTaxInfo;

    public String getComponentBundleId() {
        return componentBundleId;
    }

    public void setComponentBundleId(String componentBundleId) {
        this.componentBundleId = componentBundleId;
    }

    public String getTransactionItemId() {
        return transactionItemId;
    }

    public void setTransactionItemId(String transactionItemId) {
        this.transactionItemId = transactionItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ChargeTaxAmountInfo getEstimatedTaxInfo() {
        return estimatedTaxInfo;
    }

    public void setEstimatedTaxInfo(ChargeTaxAmountInfo estimatedTaxInfo) {
        this.estimatedTaxInfo = estimatedTaxInfo;
    }

    public String getTransactionItemName() {
        return transactionItemName;
    }

    public void setTransactionItemName(String transactionItemName) {
        this.transactionItemName = transactionItemName;
    }

    public FrequencyType getFrequencyType() { return frequencyType; }

    public void setFrequencyType(FrequencyType frequencyType) { this.frequencyType = frequencyType; }

    public static ComponentChargeView fromComponentRateSnapshot(ComponentRateSnapshot componentRateSnapshot) {
        ComponentChargeView componentChargeView = new ComponentChargeView();
        componentChargeView.setQuantity(componentRateSnapshot.getQuantity());
        componentChargeView.setTransactionItemId(componentRateSnapshot.getTransactionItemId());
        componentChargeView.setComponentBundleId(componentRateSnapshot.getComponentBundleId());
        componentChargeView.setAmount(componentRateSnapshot.getAmount());

        if (componentRateSnapshot.getFrequencyType() != null) {
            componentChargeView.setFrequencyType(FrequencyType.valueOf(componentRateSnapshot.getFrequencyType()));
        }

        return componentChargeView;
    }

    public static List<ComponentChargeView> fromComponentRateSnapshots(List<ComponentRateSnapshot> componentRateSnapshots) {

        List<ComponentChargeView> componentChargeViews = new ArrayList<>();
        componentRateSnapshots.stream().forEach(componentRateSnapshot -> componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot)));
        return componentChargeViews;
    }
}
