/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.agilysys.common.model.rate.AllowanceCombination;
import com.agilysys.common.model.rate.AllowanceFrequencyCustomOptions;
import com.agilysys.common.model.rate.AllowanceFrequencyOption;
import com.agilysys.common.model.rate.AllowanceFrequencyType;
import com.agilysys.common.model.rate.ComponentHelper;
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

    private ChargeTaxAmountInfo estimatedTaxInfo;

    private boolean reverseTax;

    private BigDecimal reverseTaxTotalChargeAmount;
    private ComponentType allowanceComponentType;
    private BigDecimal allowanceAmount;
    private AllowanceFrequencyType allowanceFrequencyType;
    private AllowanceFrequencyOption allowanceFrequencyOption;
    private List<AllowanceFrequencyCustomOptions> allowanceFrequencyCustomOptions;
    private List<AllowanceCombination> allowanceCombinations;
    private String allowanceName;
    private int allowanceTotalQuantity;
    private String breakageId;
    private boolean addOn;
    private String addOnBundleId;
    private String offerId;
    private BigDecimal offerAmount;
    private BigDecimal originalAmount;
    private BigDecimal originalAmountPerItem;
    private BigDecimal offerTaxAmount;
    private Boolean compRule;
    private String ruleName;

    public ComponentChargeView() {
        estimatedTaxInfo = new ChargeTaxAmountInfo();
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
        allowanceTotalQuantity = componentChargeView.getAllowanceTotalQuantity();
        addOn = componentChargeView.isAddOn();
        addOnBundleId = componentChargeView.getAddOnBundleId();
        compRule = componentChargeView.getCompRule();
        ruleName = componentChargeView.getRuleName();
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
        return amount != null ? amount.setScale(2, RoundingMode.HALF_UP) : amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount != null ? amount.setScale(2, RoundingMode.HALF_UP) : amount;
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
        return totalAmount != null ? totalAmount.setScale(2, RoundingMode.HALF_UP) : totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount != null ? totalAmount.setScale(2, RoundingMode.HALF_UP) : totalAmount;
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
        return allowanceAmount != null ? allowanceAmount.setScale(2, RoundingMode.HALF_UP) : allowanceAmount;
    }

    public void setAllowanceAmount(BigDecimal allowanceAmount) {
        this.allowanceAmount =
              allowanceAmount != null ? allowanceAmount.setScale(2, RoundingMode.HALF_UP) : allowanceAmount;
    }

    public AllowanceFrequencyType getAllowanceFrequencyType() {
        return allowanceFrequencyType;
    }

    public void setAllowanceFrequencyType(AllowanceFrequencyType allowanceFrequencyType) {
        this.allowanceFrequencyType = allowanceFrequencyType;
    }

    public AllowanceFrequencyOption getAllowanceFrequencyOption() {
        return allowanceFrequencyOption;
    }

    public void setAllowanceFrequencyOption(AllowanceFrequencyOption allowanceFrequencyOption) {
        this.allowanceFrequencyOption = allowanceFrequencyOption;
    }

    public List<AllowanceFrequencyCustomOptions> getAllowanceFrequencyCustomOptions() {
        return allowanceFrequencyCustomOptions;
    }

    public void setAllowanceFrequencyCustomOptions(List<AllowanceFrequencyCustomOptions> allowanceFrequencyCustomOptions) {
        this.allowanceFrequencyCustomOptions = allowanceFrequencyCustomOptions;
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

    public boolean isAddOn() {
        return addOn;
    }

    public void setAddOn(boolean addOn) {
        this.addOn = addOn;
    }

    public String getAddOnBundleId() {
        return addOnBundleId;
    }

    public void setAddOnBundleId(String addOnBundleId) {
        this.addOnBundleId = addOnBundleId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public BigDecimal getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(BigDecimal offerAmount) {
        this.offerAmount = offerAmount;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getOriginalAmountPerItem() {
        return originalAmountPerItem;
    }

    public void setOriginalAmountPerItem(BigDecimal originalAmountPerItem) {
        this.originalAmountPerItem = originalAmountPerItem;
    }

    public BigDecimal getOfferTaxAmount() {
        return offerTaxAmount;
    }

    public void setOfferTaxAmount(BigDecimal offerTaxAmount) {
        this.offerTaxAmount = offerTaxAmount;
    }

    public Boolean getCompRule() {
        return compRule;
    }

    public void setCompRule(Boolean compRule) {
        this.compRule = compRule;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public static ComponentChargeView fromComponentRateSnapshot(ComponentRateSnapshot componentRateSnapshot) {
        ComponentChargeView componentChargeView = new ComponentChargeView();
        componentChargeView.setQuantity(componentRateSnapshot.getQuantity());
        componentChargeView.setTransactionItemId(componentRateSnapshot.getTransactionItemId());
        componentChargeView.setComponentBundleId(componentRateSnapshot.getComponentBundleId());
        componentChargeView.setComponentId(componentRateSnapshot.getComponentId());
        componentChargeView.setAmount(componentRateSnapshot.getAmount().setScale(2, RoundingMode.HALF_UP));
        componentChargeView.setTotalQuantity(componentRateSnapshot.getRealizedTotalQuantity());
        componentChargeView.setTotalAmount(ComponentHelper.getTotalAmount(componentChargeView.getTotalQuantity(),
              componentChargeView.getAmount()));
        componentChargeView.setComponentType(componentRateSnapshot.getComponentType());
        componentChargeView.setRoomChargePostingType(componentRateSnapshot.getRoomChargePostingType());
        componentChargeView.setAllowanceComponentType(componentRateSnapshot.getAllowanceComponentType());
        componentChargeView.setAllowanceAmount(componentRateSnapshot.getAllowanceAmount());
        componentChargeView.setAllowanceCombinations(componentRateSnapshot.getAllowanceCombinations());
        componentChargeView.setAllowanceFrequencyType(componentRateSnapshot.getAllowanceFrequencyType());
        componentChargeView.setAllowanceFrequencyOption(componentRateSnapshot.getAllowanceFrequencyOption());
        componentChargeView.setAllowanceFrequencyCustomOptions(componentRateSnapshot.getAllowanceFrequencyCustomOptions());
        componentChargeView.setAllowanceName(componentRateSnapshot.getAllowanceName());
        componentChargeView.setAllowanceTotalQuantity(componentRateSnapshot.getAllowanceTotalQuantity());
        componentChargeView.setBreakageId(componentRateSnapshot.getBreakageId());
        componentChargeView.setAddOn(componentRateSnapshot.isAddOn());
        componentChargeView.setAddOnBundleId(componentRateSnapshot.getAddOnBundleId());

        return componentChargeView;
    }

    public static List<ComponentChargeView> fromComponentRateSnapshots(
          List<ComponentRateSnapshot> componentRateSnapshots) {
        List<ComponentChargeView> componentChargeViews = new ArrayList<>();
        componentRateSnapshots.forEach(
              componentRateSnapshot -> componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot)));

        return componentChargeViews;
    }

    public static List<ComponentChargeView> getComponentRateSnapshotsByAllowanceFrequencyType(
          List<ComponentRateSnapshot> componentRateSnapshots, Set<AllowanceFrequencyType> allowanceFrequencyTypes) {
        List<ComponentChargeView> componentChargeViews = new ArrayList<>();
        componentRateSnapshots.stream().filter(componentRateSnapshot -> allowanceFrequencyTypes
              .contains(componentRateSnapshot.getAllowanceFrequencyType())).forEach(
              componentRateSnapshot -> componentChargeViews.add(fromComponentRateSnapshot(componentRateSnapshot)));
        return componentChargeViews;
    }
}