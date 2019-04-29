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

    private BigDecimal amount;

    private int quantity;

    private int totalQuantity;

    private BigDecimal totalAmount;

    private TransactionItemType transactionItemType;

    ChargeTaxAmountInfo estimatedTaxInfo;

    public ComponentChargeView() {
    }

    public ComponentChargeView(ComponentChargeView componentChargeView) {
        componentBundleId = componentChargeView.getComponentBundleId();
        transactionItemId = componentChargeView.getTransactionItemId();
        transactionItemName = componentChargeView.getTransactionItemName();
        amount = componentChargeView.getAmount();
        quantity = componentChargeView.getQuantity();
        totalQuantity = componentChargeView.getTotalQuantity();
        totalAmount = componentChargeView.getTotalAmount();
        transactionItemType = componentChargeView.getTransactionItemType();
        estimatedTaxInfo = componentChargeView.getEstimatedTaxInfo();
    }

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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalQuantity() {
        //quantity is considered in case the recurring charges are created before this is introduced
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
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

    public TransactionItemType getTransactionItemType() {
        return transactionItemType;
    }

    public void setTransactionItemType(TransactionItemType transactionItemType) {
        this.transactionItemType = transactionItemType;
    }

    public static ComponentChargeView fromComponentRateSnapshot(ComponentRateSnapshot componentRateSnapshot) {
        ComponentChargeView componentChargeView = new ComponentChargeView();
        componentChargeView.setQuantity(componentRateSnapshot.getQuantity());
        componentChargeView.setTransactionItemId(componentRateSnapshot.getTransactionItemId());
        componentChargeView.setComponentBundleId(componentRateSnapshot.getComponentBundleId());
        componentChargeView.setAmount(componentRateSnapshot.getAmount());
        componentChargeView.setTotalQuantity(componentRateSnapshot.getRealizedTotalQuantity());
        componentChargeView.setTotalAmount(componentRateSnapshot.getRealizedTotalAmount());

        return componentChargeView;
    }

    public static List<ComponentChargeView> fromComponentRateSnapshots(
          List<ComponentRateSnapshot> componentRateSnapshots) {

        List<ComponentChargeView> componentChargeViews = new ArrayList<>(componentRateSnapshots.size());
        componentRateSnapshots.stream().forEach(
              componentRateSnapshot -> componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot)));
        return componentChargeViews;
    }
}

