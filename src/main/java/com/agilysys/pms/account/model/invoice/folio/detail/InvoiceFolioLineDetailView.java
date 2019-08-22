/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio.detail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.CompInfo;
import com.agilysys.pms.account.model.LedgerTransactionHistory;
import com.agilysys.pms.account.model.invoice.folio.InvoiceFolioLineView;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class InvoiceFolioLineDetailView extends InvoiceFolioLineView<InvoiceFolioLineDetailView> {
    private String id;

    private String categoryId;
    private CompInfo compInfo;
    private String folioId;
    private String folioLineType;
    private BigDecimal freeAllowanceAmount;
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
    private String reference;
    private String reservationId;
    private boolean roomRevenue;
    private String sourceId;
    private String transactionDestinationAccountId;
    private String transactionId;
    private String transactionReferenceId;
    private String transactionSourceAccountId;
    private String transactionType;
    private String transferMessage;
    private BigDecimal unitAmount;
    private String userId;

    @JsonIgnore
    private boolean reverseTax;

    @JsonIgnore
    private BigDecimal reverseTaxTotalChargeAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public CompInfo getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(CompInfo compInfo) {
        this.compInfo = compInfo;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public String getFolioLineType() {
        return folioLineType;
    }

    public void setFolioLineType(String folioLineType) {
        this.folioLineType = folioLineType;
    }

    public BigDecimal getFreeAllowanceAmount() {
        return freeAllowanceAmount;
    }

    public void setFreeAllowanceAmount(BigDecimal freeAllowanceAmount) {
        this.freeAllowanceAmount = freeAllowanceAmount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getLedgerId() {
        return ledgerId;
    }

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

    public String getMealPeriodId() {
        return mealPeriodId;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRateChangeComment() {
        return rateChangeComment;
    }

    public void setRateChangeComment(String rateChangeComment) {
        this.rateChangeComment = rateChangeComment;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isRoomRevenue() {
        return roomRevenue;
    }

    public void setRoomRevenue(boolean roomRevenue) {
        this.roomRevenue = roomRevenue;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTransactionDestinationAccountId() {
        return transactionDestinationAccountId;
    }

    public void setTransactionDestinationAccountId(String transactionDestinationAccountId) {
        this.transactionDestinationAccountId = transactionDestinationAccountId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionReferenceId() {
        return transactionReferenceId;
    }

    public void setTransactionReferenceId(String transactionReferenceId) {
        this.transactionReferenceId = transactionReferenceId;
    }

    public String getTransactionSourceAccountId() {
        return transactionSourceAccountId;
    }

    public void setTransactionSourceAccountId(String transactionSourceAccountId) {
        this.transactionSourceAccountId = transactionSourceAccountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransferMessage() {
        return transferMessage;
    }

    public void setTransferMessage(String transferMessage) {
        this.transferMessage = transferMessage;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
