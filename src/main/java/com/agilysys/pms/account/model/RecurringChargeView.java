/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.common.model.FrequencyType;
import com.agilysys.common.model.rate.CompInfo;

/**
 * Recurring Charges view object
 */
public class RecurringChargeView {
    private String recurringChargeId;
    private LocalDate chargeDate;

    // For a package, this will be just the room charge.
    private BigDecimal amount;
    private CompInfo compInfo;
    private String sourceId;
    private String accountId;
    private boolean deleted;
    private String folioId;
    private boolean invalid;
    private String itemId;
    private String reason;
    private Boolean posted;
    private Boolean roomCharge;
    private String overrideReason;
    private String ratePlanName;
    private String ratePlanId;
    private String petReferenceId;

    // For a package, this will be the estimated tax for the room charge
    private ChargeTaxAmountInfo estimatedTaxInfo;
    private String routedFolioId;
    private List<ComponentChargeView> componentCharges = new ArrayList<>();

    /**
     * EVERY = Every Night
     * FIRST = First Night Only
     * LAST = Last Night Only
     * EVERY_N = Every N Nights, nNights must be set > 0
     * DAYS_OF_WEEK = Specific days of the week, occurrenceDays must be set
     */
    private FrequencyType frequencyType;
    private int nNights;
    // Convention per ISO standard DateTimeConstants in org.joda.time; Monday 1 .... Sunday 7
    private Set<Integer> occurrenceDays = new HashSet<>();
    private String autoRecurringItemId;
    private boolean addQuantityToAllocation;

    //Set 1 for recurring charges which does not have quantity
    private int quantity = 1;
    private TransactionItemType transactionItemType;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean reverseTax;
    private BigDecimal reverseTaxTotalChargeAmount;

    public TransactionItemType getTransactionItemType() {
        return transactionItemType;
    }

    public void setTransactionItemType(TransactionItemType transactionItemType) {
        this.transactionItemType = transactionItemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRecurringChargeId() {
        return recurringChargeId;
    }

    public void setRecurringChargeId(String recurringChargeId) {
        this.recurringChargeId = recurringChargeId;
    }

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Boolean getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(Boolean roomCharge) {
        this.roomCharge = roomCharge;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public String getOverrideReason() {
        return overrideReason;
    }

    public void setOverrideReason(String overrideReason) {
        this.overrideReason = overrideReason;
    }

    public ChargeTaxAmountInfo getEstimatedTaxInfo() {
        return estimatedTaxInfo;
    }

    public void setEstimatedTaxInfo(ChargeTaxAmountInfo estimatedTaxInfo) {
        this.estimatedTaxInfo = estimatedTaxInfo;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
    }

    public int getnNights() {
        return nNights;
    }

    public void setnNights(int nNights) {
        this.nNights = nNights;
    }

    public Set<Integer> getOccurrenceDays() {
        return occurrenceDays;
    }

    public void setOccurrenceDays(Set<Integer> occurrenceDays) {
        this.occurrenceDays = occurrenceDays;
    }

    public String getRoutedFolioId() {
        return routedFolioId;
    }

    public void setRoutedFolioId(String routedFolioId) {
        this.routedFolioId = routedFolioId;
    }

    public List<ComponentChargeView> getComponentCharges() {
        return componentCharges;
    }

    public void setComponentCharges(List<ComponentChargeView> componentCharges) {
        this.componentCharges = componentCharges;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public CompInfo getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(CompInfo compInfo) {
        this.compInfo = compInfo;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPetReferenceId() {
        return petReferenceId;
    }

    public void setPetReferenceId(String petReferenceId) {
        this.petReferenceId = petReferenceId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAutoRecurringItemId() {
        return autoRecurringItemId;
    }

    public void setAutoRecurringItemId(String autoRecurringItemId) {
        this.autoRecurringItemId = autoRecurringItemId;
    }

    public boolean isAddQuantityToAllocation() {
        return addQuantityToAllocation;
    }

    public void setAddQuantityToAllocation(boolean addQuantityToAllocation) {
        this.addQuantityToAllocation = addQuantityToAllocation;
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
}