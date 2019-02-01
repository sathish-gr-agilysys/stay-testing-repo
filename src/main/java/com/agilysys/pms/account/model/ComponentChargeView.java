/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.agilysys.common.model.rate.ComponentRateSnapshot;
import com.agilysys.common.model.rate.ComponentType;
import com.agilysys.common.model.rate.RoomChargePostingType;

public class ComponentChargeView {

    private String componentBundleId;

    private String transactionItemId;

    private String transactionItemName;

    private BigDecimal amount;

    private int quantity;

    private int totalQuantity;

    private BigDecimal totalAmount;

    private ComponentType componentType;

    private RoomChargePostingType roomChargePostingType;

    private TransactionItemType transactionItemType;

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

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public RoomChargePostingType getRoomChargePostingType() {
        return roomChargePostingType;
    }

    public void setRoomChargePostingType(RoomChargePostingType roomChargePostingType) {
        this.roomChargePostingType = roomChargePostingType;
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
        componentChargeView.setComponentType(componentRateSnapshot.getComponentType());
        componentChargeView.setRoomChargePostingType(componentRateSnapshot.getRoomChargePostingType());

        return componentChargeView;
    }

    public static List<ComponentChargeView> fromComponentRateSnapshots(
          List<ComponentRateSnapshot> componentRateSnapshots, boolean isAfterDateRollChargesPosted,
          boolean isChargesPosted, AccountStatus accountStatus) {

        List<ComponentChargeView> componentChargeViews = new ArrayList<>();
        for (ComponentRateSnapshot componentRateSnapshot : componentRateSnapshots) {
            if (RoomChargePostingType.BEFORE_DATE_ROLL == componentRateSnapshot.getRoomChargePostingType()) {
                if (!isChargesPosted && AccountStatus.OPEN == accountStatus)
                    componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot));
            } else {
                if (isAfterDateRollChargesPosted || AccountStatus.CLOSED == accountStatus) {
                    componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot));
                }
            }
        }
        return componentChargeViews;
    }

    public static List<ComponentChargeView> fromComponentRateSnapshots(
          List<ComponentRateSnapshot> componentRateSnapshots) {

        List<ComponentChargeView> componentChargeViews = new ArrayList<>();
        componentRateSnapshots.stream().forEach(
              componentRateSnapshot -> componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot)));
        return componentChargeViews;
    }
}
