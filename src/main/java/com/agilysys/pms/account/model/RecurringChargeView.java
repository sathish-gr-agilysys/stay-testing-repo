/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.common.model.FrequencyType;
import com.agilysys.common.model.rate.ChargeSnapshot.ChargeType;
import com.agilysys.common.model.rate.CompInfo;
import com.agilysys.common.model.rate.RoomChargePostingType;
import com.agilysys.pms.common.allowance.conversion.PackageAllowanceSettingConversion;
import com.agilysys.pms.reservation.model.AllowanceFrequencySetting;

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
    private String referenceId;
    private ChargeType chargeType;

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
    private AutoRecurringItem autoRecurringItemSnapshot;
    private String autoRecurringRuleId;
    private boolean addQuantityToAllocation;

    //Set 1 for recurring charges which does not have quantity
    private int quantity = 1;
    private TransactionItemType transactionItemType;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean reverseTax;
    private BigDecimal reverseTaxTotalChargeAmount;
    private String packageFolioId;
    private String offerId;
    private BigDecimal offerAmount;
    private BigDecimal offerTaxAmount;
    private BigDecimal originalAmount;
    private RoomChargePostingType roomChargePostingType;
    private Boolean compRule;
    private String ruleName;
    private BigDecimal includeTaxAmount;

    public RecurringChargeView() {
        estimatedTaxInfo = new ChargeTaxAmountInfo();
    }

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
        return amount != null ? amount.setScale(2, RoundingMode.HALF_UP) : amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount != null ? amount.setScale(2, RoundingMode.HALF_UP) : amount;
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
        for (ComponentChargeView componentChargeView : componentCharges) {
            if (componentChargeView.getAllowanceFrequencyType() != null) {
                setAllowanceSetting(componentChargeView);
            }
        }
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

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
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

    public AutoRecurringItem getAutoRecurringItemSnapshot() {
        return autoRecurringItemSnapshot;
    }

    public void setAutoRecurringItemSnapshot(AutoRecurringItem autoRecurringItemSnapshot) {
        this.autoRecurringItemSnapshot = autoRecurringItemSnapshot;
    }

    public String getAutoRecurringRuleId() {
        return autoRecurringRuleId;
    }

    public void setAutoRecurringRuleId(String autoRecurringRuleId) {
        this.autoRecurringRuleId = autoRecurringRuleId;
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

    public String getPackageFolioId() {
        return packageFolioId;
    }

    public void setPackageFolioId(String packageFolioId) {
        this.packageFolioId = packageFolioId;
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

    public BigDecimal getOfferTaxAmount() {
        return offerTaxAmount;
    }

    public void setOfferTaxAmount(BigDecimal offerTaxAmount) {
        this.offerTaxAmount = offerTaxAmount;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public RoomChargePostingType getRoomChargePostingType() {
        return roomChargePostingType;
    }

    public void setRoomChargePostingType(RoomChargePostingType roomChargePostingType) {
        this.roomChargePostingType = roomChargePostingType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
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

    public BigDecimal getIncludeTaxAmount() {
        return includeTaxAmount;
    }

    public void setIncludeTaxAmount(BigDecimal includeTaxAmount) {
        this.includeTaxAmount = includeTaxAmount;
    }

    private void setAllowanceSetting(ComponentChargeView componentChargeView) {
        AllowanceFrequencySetting allowanceFrequencySetting =
              PackageAllowanceSettingConversion.getNewPackageAllowanceSetting(
                    componentChargeView.getAllowanceFrequencyType(), this.frequencyType);
        componentChargeView.setAllowanceFrequencyOption(allowanceFrequencySetting.getAllowanceFrequencyOption());
        componentChargeView.setAllowanceFrequencyCustomOptions(
              allowanceFrequencySetting.getAllowanceFrequencyCustomOptions());
    }
}