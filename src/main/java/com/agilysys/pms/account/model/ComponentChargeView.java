/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.agilysys.common.model.rate.AllowanceCombination;
import com.agilysys.common.model.rate.AllowanceFrequencyType;
import com.agilysys.common.model.rate.ComponentRateSnapshot;
import com.agilysys.common.model.rate.ComponentType;
import com.agilysys.common.model.rate.RoomChargePostingType;

public class ComponentChargeView {

    private String componentBundleId;

    private String componentId;

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

    private boolean reverseTax;

    private BigDecimal reverseTaxTotalChargeAmount;

    private ComponentType allowanceComponentType;
    private BigDecimal allowanceAmount;
    private AllowanceFrequencyType allowanceFrequencyType;
    private List<AllowanceCombination> allowanceCombinations;
    private String allowanceName;
    private int allowanceTotalQuantity;
    private String breakageId;
    private ChargeTaxAmountInfo breakageEstimatedTaxInfo;

    public ComponentChargeView() {
    }

    public ComponentChargeView(ComponentChargeView componentChargeView) {
        componentBundleId = componentChargeView.getComponentBundleId();
        componentId = componentChargeView.componentId;
        transactionItemId = componentChargeView.getTransactionItemId();
        transactionItemName = componentChargeView.getTransactionItemName();
        amount = componentChargeView.getAmount();
        quantity = componentChargeView.getQuantity();
        totalQuantity = componentChargeView.getTotalQuantity();
        totalAmount = componentChargeView.getTotalAmount();
        componentType = componentChargeView.getComponentType();
        roomChargePostingType = componentChargeView.getRoomChargePostingType();
        transactionItemType = componentChargeView.getTransactionItemType();
        estimatedTaxInfo = componentChargeView.getEstimatedTaxInfo();
        allowanceAmount = componentChargeView.getAllowanceAmount();
        allowanceCombinations = componentChargeView.getAllowanceCombinations();
        allowanceComponentType = componentChargeView.getAllowanceComponentType();
        allowanceFrequencyType = componentChargeView.getAllowanceFrequencyType();
        allowanceName = componentChargeView.getAllowanceName();
        breakageId = componentChargeView.getBreakageId();
        breakageEstimatedTaxInfo = componentChargeView.getBreakageEstimatedTaxInfo();
    }

    public String getComponentBundleId() {
        return componentBundleId;
    }

    public void setComponentBundleId(String componentBundleId) {
        this.componentBundleId = componentBundleId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
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

    public boolean isReverseTax() {
        return reverseTax;
    }

    public void setReverseTax(boolean reverseTax) {
        this.reverseTax = reverseTax;
    }

    public BigDecimal getReverseTaxTotalChargeAmount() {
        return reverseTaxTotalChargeAmount;
    }

    public void setReverseTaxTotalChargeAmount(BigDecimal reverseTaxTotalChargeAmount) {
        this.reverseTaxTotalChargeAmount = reverseTaxTotalChargeAmount;
    }

    public ComponentType getAllowanceComponentType() {
        return allowanceComponentType;
    }

    public void setAllowanceComponentType(ComponentType allowanceComponentType) {
        this.allowanceComponentType = allowanceComponentType;
    }

    public BigDecimal getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(BigDecimal allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public AllowanceFrequencyType getAllowanceFrequencyType() {
        return allowanceFrequencyType;
    }

    public void setAllowanceFrequencyType(AllowanceFrequencyType allowanceFrequencyType) {
        this.allowanceFrequencyType = allowanceFrequencyType;
    }

    public List<AllowanceCombination> getAllowanceCombinations() {
        return allowanceCombinations;
    }

    public void setAllowanceCombinations(List<AllowanceCombination> allowanceCombinations) {
        this.allowanceCombinations = allowanceCombinations;
    }

    public String getAllowanceName() {
        return allowanceName;
    }

    public void setAllowanceName(String allowanceName) {
        this.allowanceName = allowanceName;
    }

    public int getAllowanceTotalQuantity() {
        return allowanceTotalQuantity;
    }

    public void setAllowanceTotalQuantity(int allowanceTotalQuantity) {
        this.allowanceTotalQuantity = allowanceTotalQuantity;
    }

    public String getBreakageId() {
        return breakageId;
    }

    public void setBreakageId(String breakageId) {
        this.breakageId = breakageId;
    }

    public ChargeTaxAmountInfo getBreakageEstimatedTaxInfo() {
        return breakageEstimatedTaxInfo;
    }

    public void setBreakageEstimatedTaxInfo(ChargeTaxAmountInfo breakageEstimatedTaxInfo) {
        this.breakageEstimatedTaxInfo = breakageEstimatedTaxInfo;
    }

    public static ComponentChargeView fromComponentRateSnapshot(ComponentRateSnapshot componentRateSnapshot) {
        ComponentChargeView componentChargeView = new ComponentChargeView();
        componentChargeView.setQuantity(componentRateSnapshot.getQuantity());
        componentChargeView.setTransactionItemId(componentRateSnapshot.getTransactionItemId());
        componentChargeView.setComponentBundleId(componentRateSnapshot.getComponentBundleId());
        componentChargeView.setComponentId(componentRateSnapshot.getComponentId());
        componentChargeView.setAmount(componentRateSnapshot.getAmount());
        componentChargeView.setTotalQuantity(componentRateSnapshot.getRealizedTotalQuantity());
        componentChargeView.setTotalAmount(componentRateSnapshot.getRealizedTotalAmount());
        componentChargeView.setComponentType(componentRateSnapshot.getComponentType());
        componentChargeView.setRoomChargePostingType(componentRateSnapshot.getRoomChargePostingType());
        componentChargeView.setAllowanceComponentType(componentRateSnapshot.getAllowanceComponentType());
        componentChargeView.setAllowanceAmount(componentRateSnapshot.getAllowanceAmount());
        componentChargeView.setAllowanceCombinations(componentRateSnapshot.getAllowanceCombinations());
        componentChargeView.setAllowanceFrequencyType(componentRateSnapshot.getAllowanceFrequencyType());
        componentChargeView.setAllowanceName(componentRateSnapshot.getAllowanceName());
        componentChargeView.setAllowanceTotalQuantity(componentRateSnapshot.getAllowanceTotalQuantity());
        componentChargeView.setBreakageId(componentRateSnapshot.getBreakageId());

        return componentChargeView;
    }

    public static List<ComponentChargeView> fromComponentRateSnapshots(
          List<ComponentRateSnapshot> componentRateSnapshots) {
        List<ComponentChargeView> componentChargeViews = new ArrayList<>();
        componentRateSnapshots.stream().forEach(
              componentRateSnapshot -> componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot)));
        return componentChargeViews;
    }
}
