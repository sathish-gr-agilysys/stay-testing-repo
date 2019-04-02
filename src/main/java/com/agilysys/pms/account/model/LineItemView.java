/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.CompInfo;
import com.agilysys.common.model.rate.ComponentType;
import com.agilysys.common.model.rate.RoomChargePostingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Folio/Ledger LineItem provided to the UI. This is a view on data managed
 * using:
 * <ul>
 * <li>LedgerTransaction</li>
 * <li>LineItem</li>
 * </ul>
 *
 * @see <a
 * href="http://confluence.bellevue.ad.local/display/VICTRIAL/View+Line+Item+Object">LineItemView</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemView implements Comparable<LineItemView> {
    private String id;

    private String accountId;
    private List<LineItemView> adjustmentLineItems;
    private boolean autoRouted;
    private String callType;
    private String categoryId;
    private CompInfo compInfo;
    private ComponentType componentType;
    private RoomChargePostingType roomChargePostingType;
    private LineItemView correctionLineItem;
    private String description;
    private LocalDate displayDate;
    private boolean distributed;
    private String folioId;
    private String folioLineType;
    private BigDecimal freeAllowanceAmount;
    private boolean invalid;
    private List<LineItemView> groupedTaxLineItems;
    private String itemId;
    private String ledgerId;
    private List<LedgerTransactionHistory> ledgerTransactionHistory;
    private String ledgerTransactionHistoryId;
    private String mealPeriodId;
    private String name;
    private String parentId;
    private String petDisplayName;
    private DateTime postingCalendarDateTime;
    private LocalDate postingPropertyDate;
    private int quantity;
    private String rateChangeComment;
    private List<LineItemView> refundLineItems;
    private String reason;
    private String receiptTextImage;
    private String recurringChargeId;
    private String reference;
    private String reservationId;
    private boolean roomRevenue;
    private boolean routed;
    private String sourceId;
    private String subcategoryId;
    private List<LineItemView> taxLineItems;
    private String transactionDestinationAccountId;
    private LineItemView transferLineItem;
    private String transactionId;
    private Map<String, String> transactionMessageAttributes;
    private String transactionSourceAccountId;
    private String transactionType;
    private BigDecimal unitAmount;
    private String userId;
    private String autoRecurringItemId;
    private List<PantryItemDetails> pantryItemDetails;
    private Boolean pantryItem;

    public LineItemView() {
        adjustmentLineItems = new ArrayList<>();
        freeAllowanceAmount = BigDecimal.ZERO;
        groupedTaxLineItems = new ArrayList<>();
        refundLineItems = new ArrayList<>();
        taxLineItems = new ArrayList<>();
    }

    /**
     * @return the ID of the LineItem
     */
    public String getId() {
        return id;
    }

    /**
     * @param id Set the ID of the LineItem
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the accountId. Must not be null
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId Set the accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<LineItemView> getAdjustmentLineItems() {
        return adjustmentLineItems != null ? adjustmentLineItems : new ArrayList<>();
    }

    public void setAdjustmentLineItems(List<LineItemView> adjustmentLineItems) {
        this.adjustmentLineItems = adjustmentLineItems;
    }

    public boolean isAutoRouted() {
        return autoRouted;
    }

    public void setAutoRouted(boolean autoRouted) {
        this.autoRouted = autoRouted;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId Set the transaction categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public CompInfo getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(CompInfo compInfo) {
        this.compInfo = compInfo;
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

    public LineItemView getCorrectionLineItem() {
        return correctionLineItem;
    }

    public void setCorrectionLineItem(LineItemView correctionLineItem) {
        this.correctionLineItem = correctionLineItem;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Set the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public boolean isDistributed() {
        return distributed;
    }

    public void setDistributed(boolean distributed) {
        this.distributed = distributed;
    }

    /**
     * @return the folioId
     */
    public String getFolioId() {
        return folioId;
    }

    /**
     * @param folioId Set the folioId
     */
    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public String getFolioLineType() {
        return folioLineType;
    }

    public void setFolioLineType(String folioLineType) {
        this.folioLineType = folioLineType;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public List<LineItemView> getGroupedTaxLineItems() {
        return groupedTaxLineItems;
    }

    public void setGroupedTaxLineItems(List<LineItemView> groupedTaxLineItems) {
        this.groupedTaxLineItems = groupedTaxLineItems;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId Set the transaction itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the ledgerId. Will be null for folio's
     */
    public String getLedgerId() {
        return ledgerId;
    }

    /**
     * @param ledgerId Set the ledgerId
     */
    public void setLedgerId(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public List<LedgerTransactionHistory> getLedgerTransactionHistory() {
        return ledgerTransactionHistory;
    }

    public void setLedgerTransactionHistory(List<LedgerTransactionHistory> ledgerTransactionHistory) {
        this.ledgerTransactionHistory = ledgerTransactionHistory;
    }

    public String getLedgerTransactionHistoryId() {
        return ledgerTransactionHistoryId;
    }

    public void setLedgerTransactionHistoryId(String ledgerTransactionHistoryId) {
        this.ledgerTransactionHistoryId = ledgerTransactionHistoryId;
    }

    /**
     * @return the mealPeriodId
     */
    public String getMealPeriodId() {
        return mealPeriodId;
    }

    /**
     * @param mealPeriodId Set the mealPeriodId
     */
    public void setMealPeriodId(String mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPetDisplayName() {
        return petDisplayName;
    }

    public void setPetDisplayName(String petDisplayName) {
        this.petDisplayName = petDisplayName;
    }

    public DateTime getPostingCalendarDateTime() {
        return postingCalendarDateTime;
    }

    public void setPostingCalendarDateTime(DateTime postingCalendarDateTime) {
        this.postingCalendarDateTime = postingCalendarDateTime;
    }

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity Set the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRateChangeComment() {
        return rateChangeComment;
    }

    public void setRateChangeComment(String rateChangeComment) {
        this.rateChangeComment = rateChangeComment;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason Set the reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReceiptTextImage() {
        return receiptTextImage;
    }

    public void setReceiptTextImage(String receiptTextImage) {
        this.receiptTextImage = receiptTextImage;
    }

    public String getRecurringChargeId() {
        return recurringChargeId;
    }

    public void setRecurringChargeId(String recurringChargeId) {
        this.recurringChargeId = recurringChargeId;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference != null ? reference : "";
    }

    /**
     * @param reference Set the reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the reservationId. Will be null if account is not linked to a
     * reservation
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId Set the reservationId
     */
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isRoomRevenue() {
        return roomRevenue;
    }

    public void setRoomRevenue(boolean roomRevenue) {
        this.roomRevenue = roomRevenue;
    }

    public boolean isRouted() {
        return routed;
    }

    public void setRouted(boolean routed) {
        this.routed = routed;
    }

    public List<LineItemView> getRefundLineItems() {
        return refundLineItems != null ? refundLineItems : new ArrayList<>();
    }

    public void setRefundLineItems(List<LineItemView> refundLineItems) {
        this.refundLineItems = refundLineItems;
    }

    /**
     * @return the sourceId
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * @param sourceId Set the sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * @return the subcategoryId
     */
    public String getSubcategoryId() {
        return subcategoryId;
    }

    /**
     * @param subcategoryId Set the transaction subcategoryId
     */
    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    /**
     * @return the taxLineItems
     */
    public List<LineItemView> getTaxLineItems() {
        return taxLineItems != null ? taxLineItems : new ArrayList<>();
    }

    /**
     * @param taxLineItems Set the taxLineItems
     */
    public void setTaxLineItems(List<LineItemView> taxLineItems) {
        this.taxLineItems = taxLineItems;
    }

    public String getTransactionDestinationAccountId() {
        return transactionDestinationAccountId;
    }

    public void setTransactionDestinationAccountId(String transactionDestinationAccountId) {
        this.transactionDestinationAccountId = transactionDestinationAccountId;
    }

    public Map<String, String> getTransactionMessageAttributes() {
        return transactionMessageAttributes;
    }

    /**
     * @return the ID of the LedgerTransaction the LineItem is part of
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId Set the ID of the transaction
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    public String getTransactionSourceAccountId() {
        return transactionSourceAccountId;
    }

    public void setTransactionSourceAccountId(String transactionSourceAccountId) {
        this.transactionSourceAccountId = transactionSourceAccountId;
    }

    /**
     * @return the type of the LedgerTransaction.
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType Set the TransactionType for the transaction
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LineItemView getTransferLineItem() {
        return transferLineItem;
    }

    public void setTransferLineItem(LineItemView transferLineItem) {
        this.transferLineItem = transferLineItem;
    }

    /**
     * @return the unitAmount
     */
    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    /**
     * @param unitAmount Set the unitAmount
     */
    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId Set the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAutoRecurringItemId() {
        return autoRecurringItemId;
    }

    public void setAutoRecurringItemId(String autoRecurringItemId) {
        this.autoRecurringItemId = autoRecurringItemId;
    }

    /**
     * @return total + taxes of the adjustments on this line item
     */
    public BigDecimal getAdjustmentsGrandTotalAmount() {
        return getAdjustmentsTotalAmount().add(getAdjustmentsTaxAmount());
    }

    /**
     * @return amount of adjustment tax
     */
    public BigDecimal getAdjustmentsTaxAmount() {
        BigDecimal adjustmentsTaxAmount = BigDecimal.ZERO;
        for (LineItemView adjustment : getAdjustmentLineItems()) {
            adjustmentsTaxAmount = adjustmentsTaxAmount.add(adjustment.getTaxAmount());
        }

        return adjustmentsTaxAmount;
    }

    /**
     * @return amount of adjustments
     */
    public BigDecimal getAdjustmentsTotalAmount() {
        BigDecimal adjustmentsTotalAmount = BigDecimal.ZERO;
        for (LineItemView adjustment : getAdjustmentLineItems()) {
            adjustmentsTotalAmount = adjustmentsTotalAmount.add(adjustment.getTotalAmount());
        }

        return adjustmentsTotalAmount;
    }

    /**
     * @return total + taxes of an associated correction line item
     */
    public BigDecimal getCorrectionGrandTotalAmount() {
        return getCorrectionTotalAmount().add(getCorrectionTaxAmount());
    }

    /**
     * @return correction tax amount
     */
    public BigDecimal getCorrectionTaxAmount() {
        BigDecimal correctionTaxAmount = BigDecimal.ZERO;
        LineItemView correction = getCorrectionLineItem();
        if (correction != null) {
            correctionTaxAmount = correctionTaxAmount.add(correction.getTaxAmount());
        }

        return correctionTaxAmount;
    }

    /**
     * @return correction amount
     */
    public BigDecimal getCorrectionTotalAmount() {
        BigDecimal correctionTotalAmount = BigDecimal.ZERO;
        LineItemView correction = getCorrectionLineItem();
        if (correction != null) {
            correctionTotalAmount = correctionTotalAmount.add(correction.getTotalAmount());
        }

        return correctionTotalAmount;
    }

    /**
     * @return total + taxes of this line item
     */
    public BigDecimal getGrandTotalAmount() {
        return getTotalAmount().add(getTaxAmount());
    }

    /**
     * @return the balance of the {@link LineItemView} including all charges and
     * tax
     */
    public BigDecimal getLineItemBalance() {
        return getGrandTotalAmount().add(getAdjustmentsGrandTotalAmount()).add(getTransferGrandTotalAmount())
              .add(getCorrectionGrandTotalAmount().add(getRefundGrantTotalAmount()));
    }

    /**
     * @return the balance of the {@link LineItemView} minus tax
     */
    public BigDecimal getLineItemChargesBalance() {
        return getTotalAmount().add(getAdjustmentsTotalAmount()).add(getTransferTotalAmount())
              .add(getCorrectionTotalAmount()).add(getRefundGrantTotalAmount());
    }

    /**
     * @return the balance of all tax items associated with the
     * {@link LineItemView}
     */
    public BigDecimal getLineItemTaxBalance() {
        return getTaxAmount().add(getAdjustmentsTaxAmount()).add(getTransferTaxAmount()).add(getCorrectionTaxAmount());
    }

    /**
     * @return the total refund amount
     */
    public BigDecimal getRefundGrantTotalAmount() {
        BigDecimal refundAmount = BigDecimal.ZERO;
        for (LineItemView refund : getRefundLineItems()) {
            refundAmount = refundAmount.add(refund.getGrandTotalAmount());
        }

        return refundAmount;
    }

    /**
     * @return the taxAmount. Will be zero until taxes are implemented
     */
    public BigDecimal getTaxAmount() {
        BigDecimal taxAmount = BigDecimal.ZERO;
        for (LineItemView tax : getTaxLineItems()) {
            taxAmount = taxAmount.add(tax.getUnitAmount().multiply(new BigDecimal(tax.getQuantity())));
        }

        return taxAmount;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return unitAmount.multiply(new BigDecimal(quantity));
    }

    /**
     * @return total + taxes of an associated transferred line item
     */
    public BigDecimal getTransferGrandTotalAmount() {
        return getTransferTotalAmount().add(getTransferTaxAmount());
    }

    /**
     * @return transfer tax amount
     */
    public BigDecimal getTransferTaxAmount() {
        BigDecimal transferTaxAmount = BigDecimal.ZERO;
        LineItemView transfer = getTransferLineItem();
        if (transfer != null) {
            transferTaxAmount = transferTaxAmount.add(transfer.getTaxAmount());
        }

        return transferTaxAmount;
    }

    /**
     * @return transfer amount
     */
    public BigDecimal getTransferTotalAmount() {
        BigDecimal transferTotalAmount = BigDecimal.ZERO;
        LineItemView transfer = getTransferLineItem();
        if (transfer != null) {
            transferTotalAmount = transferTotalAmount.add(transfer.getTotalAmount());
        }

        return transferTotalAmount;
    }

    @JsonIgnore
    public String getFolioLineOrTransactionType() {
        return folioLineType != null ? folioLineType : transactionType;
    }

    public BigDecimal getFreeAllowanceAmount() {
        return freeAllowanceAmount;
    }

    public void setFreeAllowanceAmount(BigDecimal freeAllowanceAmount) {
        this.freeAllowanceAmount = freeAllowanceAmount;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public List<PantryItemDetails> getPantryItemDetails() {
        return pantryItemDetails;
    }

    public void setPantryItemDetails(List<PantryItemDetails> pantryItemDetails) {
        this.pantryItemDetails = pantryItemDetails;
    }

    public Boolean getPantryItem() {
        return pantryItem;
    }

    public void setPantryItem(Boolean pantryItem) {
        this.pantryItem = pantryItem;
    }

    @Override
    public int compareTo(LineItemView other) {
        if (this.getDisplayDate() != null && other.getDisplayDate() != null) {
            if (this.getDisplayDate().isBefore(other.getDisplayDate())) {
                return -1;
            } else if (this.getDisplayDate().isAfter(other.getDisplayDate())) {
                return 1;
            }
        }

        if (this.getPostingCalendarDateTime() != null && other.getPostingCalendarDateTime() != null) {

            if (this.getPostingCalendarDateTime().isBefore(other.getPostingCalendarDateTime())) {
                return -1;
            } else if (this.getPostingCalendarDateTime().isAfter(other.getPostingCalendarDateTime())) {
                return 1;
            }
        }

        // line items that are routed will have the same displayDate and postingCalendarDateTime
        // we want to show the positive charge first, and then the negative one
        if (routed || other.isRouted()) {
            if (!other.isRouted()) {
                return -1;
            } else if (!routed) {
                return 1;
            } else {
                return other.getGrandTotalAmount().compareTo(this.getGrandTotalAmount());
            }
        }

        return 0;
    }
}