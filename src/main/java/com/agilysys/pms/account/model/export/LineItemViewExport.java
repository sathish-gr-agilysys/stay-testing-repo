/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.export;

import java.math.BigDecimal;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.pms.common.model.export.ExportMapSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class LineItemViewExport {
    private String id;
    private String transactionId;
    private String transactionType;
    private String transactionSourceAccountId;
    private String transactionDestinationAccountId;
    @JsonSerialize(using = ExportMapSerializer.class)
    private Map<String, String> transactionMessageAttributes;
    private LocalDate postingPropertyDate;
    private DateTime postingCalendarDateTime;
    private LocalDate displayDate;
    private String reservationId;
    private String accountId;
    private String folioId;
    private String ledgerId;
    private BigDecimal unitAmount;
    private int quantity;
    private String sourceId;
    private String categoryId;
    private String subcategoryId;
    private String itemId;
    private String description;
    private String mealPeriodId;
    private String userId;
    private String reason;
    private String reference;
    private String recurringChargeId;
    private boolean routed;
    private boolean roomRevenue;
    private BigDecimal lineItemBalance;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;
    private BigDecimal refundGrantTotalAmount;
    private BigDecimal grandTotalAmount;
    private BigDecimal adjustmentsTotalAmount;
    private BigDecimal adjustmentsTaxAmount;
    private BigDecimal adjustmentsGrandTotalAmount;
    private BigDecimal transferTotalAmount;
    private BigDecimal transferTaxAmount;
    private BigDecimal transferGrandTotalAmount;
    private BigDecimal correctionTotalAmount;
    private BigDecimal correctionTaxAmount;
    private BigDecimal correctionGrandTotalAmount;
    private BigDecimal lineItemChargesBalance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionSourceAccountId() {
        return transactionSourceAccountId;
    }

    public void setTransactionSourceAccountId(String transactionSourceAccountId) {
        this.transactionSourceAccountId = transactionSourceAccountId;
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

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public DateTime getPostingCalendarDateTime() {
        return postingCalendarDateTime;
    }

    public void setPostingCalendarDateTime(DateTime postingCalendarDateTime) {
        this.postingCalendarDateTime = postingCalendarDateTime;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
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

    public String getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealPeriodId() {
        return mealPeriodId;
    }

    public void setMealPeriodId(String mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRecurringChargeId() {
        return recurringChargeId;
    }

    public void setRecurringChargeId(String recurringChargeId) {
        this.recurringChargeId = recurringChargeId;
    }

    public boolean isRouted() {
        return routed;
    }

    public void setRouted(boolean routed) {
        this.routed = routed;
    }

    public boolean isRoomRevenue() {
        return roomRevenue;
    }

    public void setRoomRevenue(boolean roomRevenue) {
        this.roomRevenue = roomRevenue;
    }

    public BigDecimal getLineItemBalance() {
        return lineItemBalance;
    }

    public void setLineItemBalance(BigDecimal lineItemBalance) {
        this.lineItemBalance = lineItemBalance;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getRefundGrantTotalAmount() {
        return refundGrantTotalAmount;
    }

    public void setRefundGrantTotalAmount(BigDecimal refundGrantTotalAmount) {
        this.refundGrantTotalAmount = refundGrantTotalAmount;
    }

    public BigDecimal getGrandTotalAmount() {
        return grandTotalAmount;
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    public BigDecimal getAdjustmentsTotalAmount() {
        return adjustmentsTotalAmount;
    }

    public void setAdjustmentsTotalAmount(BigDecimal adjustmentsTotalAmount) {
        this.adjustmentsTotalAmount = adjustmentsTotalAmount;
    }

    public BigDecimal getAdjustmentsTaxAmount() {
        return adjustmentsTaxAmount;
    }

    public void setAdjustmentsTaxAmount(BigDecimal adjustmentsTaxAmount) {
        this.adjustmentsTaxAmount = adjustmentsTaxAmount;
    }

    public BigDecimal getAdjustmentsGrandTotalAmount() {
        return adjustmentsGrandTotalAmount;
    }

    public void setAdjustmentsGrandTotalAmount(BigDecimal adjustmentsGrandTotalAmount) {
        this.adjustmentsGrandTotalAmount = adjustmentsGrandTotalAmount;
    }

    public BigDecimal getTransferTotalAmount() {
        return transferTotalAmount;
    }

    public void setTransferTotalAmount(BigDecimal transferTotalAmount) {
        this.transferTotalAmount = transferTotalAmount;
    }

    public BigDecimal getTransferTaxAmount() {
        return transferTaxAmount;
    }

    public void setTransferTaxAmount(BigDecimal transferTaxAmount) {
        this.transferTaxAmount = transferTaxAmount;
    }

    public BigDecimal getTransferGrandTotalAmount() {
        return transferGrandTotalAmount;
    }

    public void setTransferGrandTotalAmount(BigDecimal transferGrandTotalAmount) {
        this.transferGrandTotalAmount = transferGrandTotalAmount;
    }

    public BigDecimal getCorrectionTotalAmount() {
        return correctionTotalAmount;
    }

    public void setCorrectionTotalAmount(BigDecimal correctionTotalAmount) {
        this.correctionTotalAmount = correctionTotalAmount;
    }

    public BigDecimal getCorrectionTaxAmount() {
        return correctionTaxAmount;
    }

    public void setCorrectionTaxAmount(BigDecimal correctionTaxAmount) {
        this.correctionTaxAmount = correctionTaxAmount;
    }

    public BigDecimal getCorrectionGrandTotalAmount() {
        return correctionGrandTotalAmount;
    }

    public void setCorrectionGrandTotalAmount(BigDecimal correctionGrandTotalAmount) {
        this.correctionGrandTotalAmount = correctionGrandTotalAmount;
    }

    public BigDecimal getLineItemChargesBalance() {
        return lineItemChargesBalance;
    }

    public void setLineItemChargesBalance(BigDecimal lineItemChargesBalance) {
        this.lineItemChargesBalance = lineItemChargesBalance;
    }
}