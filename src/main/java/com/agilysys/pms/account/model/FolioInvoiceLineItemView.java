/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class FolioInvoiceLineItemView extends FolioViewLineItem {

    private String formattedDisplayDate;
    private String formattedTotalAmount;
    private String originalBalance;
    private String newBalance;
    private String adjustmentMessage;
    private String refundMessage;
    private String transferOutTransactionMessage;
    private String correctionMessage;
    private String correctedMessage;
    private String creditMessage;
    private String balanceTransferMessage;
    private String transferInMessage;
    private String formattedGrandTotalAmount;
    private String formattedLineItemBalance;
    private String formattedUnitAmount;
    private String formattedAdjustmentsGrandTotalAmount;
    private String formattedAdjustmentsTaxAmount;
    private String formattedCorrectionGrandTotalAmount;
    private String formattedRefundGrandTotalAmount;
    private String formattedTaxAmount;
    private String formattedCorrectionTaxAmount;
    private boolean showReason;
    private List<FolioInvoiceLineItemView> adjustmentFolioLineItems;
    private List<FolioInvoiceLineItemView> groupedFolioTaxLineItems;
    private List<FolioInvoiceLineItemView> refundFolioLineItems;
    private List<FolioInvoiceLineItemView> taxFolioLineItems;
    private FolioInvoiceLineItemView correctionFolioLineItem;
    private LineItemView transferFolioLineItem;

    public String getFormattedDisplayDate() {
        return formattedDisplayDate;
    }

    public void setFormattedDisplayDate(String formattedDisplayDate) {
        this.formattedDisplayDate = formattedDisplayDate;
    }

    public String getFormattedTotalAmount() {
        return formattedTotalAmount;
    }

    public void setFormattedTotalAmount(String formattedTotalAmount) {
        this.formattedTotalAmount = formattedTotalAmount;
    }

    public String getOriginalBalance() {
        return originalBalance;
    }

    public void setOriginalBalance(String originalBalance) {
        this.originalBalance = originalBalance;
    }

    public String getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(String newBalance) {
        this.newBalance = newBalance;
    }

    public String getAdjustmentMessage() {
        return adjustmentMessage;
    }

    public void setAdjustmentMessage(String adjustmentMessage) {
        this.adjustmentMessage = adjustmentMessage;
    }

    public String getRefundMessage() {
        return refundMessage;
    }

    public void setRefundMessage(String refundMessage) {
        this.refundMessage = refundMessage;
    }

    public String getTransferOutTransactionMessage() {
        return transferOutTransactionMessage;
    }

    public void setTransferOutTransactionMessage(String transferOutTransactionMessage) {
        this.transferOutTransactionMessage = transferOutTransactionMessage;
    }

    public String getCorrectionMessage() {
        return correctionMessage;
    }

    public void setCorrectionMessage(String correctionMessage) {
        this.correctionMessage = correctionMessage;
    }

    public String getCorrectedMessage() {
        return correctedMessage;
    }

    public void setCorrectedMessage(String correctedMessage) {
        this.correctedMessage = correctedMessage;
    }

    public String getCreditMessage() {
        return creditMessage;
    }

    public void setCreditMessage(String creditMessage) {
        this.creditMessage = creditMessage;
    }

    public String getBalanceTransferMessage() {
        return balanceTransferMessage;
    }

    public void setBalanceTransferMessage(String balanceTransferMessage) {
        this.balanceTransferMessage = balanceTransferMessage;
    }

    public String getTransferInMessage() {
        return transferInMessage;
    }

    public void setTransferInMessage(String transferInMessage) {
        this.transferInMessage = transferInMessage;
    }

    public String getFormattedGrandTotalAmount() {
        return formattedGrandTotalAmount;
    }

    public void setFormattedGrandTotalAmount(String formattedGrandTotalAmount) {
        this.formattedGrandTotalAmount = formattedGrandTotalAmount;
    }

    public String getFormattedLineItemBalance() {
        return formattedLineItemBalance;
    }

    public void setFormattedLineItemBalance(String formattedLineItemBalance) {
        this.formattedLineItemBalance = formattedLineItemBalance;
    }

    public String getFormattedUnitAmount() {
        return formattedUnitAmount;
    }

    public void setFormattedUnitAmount(String formattedUnitAmount) {
        this.formattedUnitAmount = formattedUnitAmount;
    }

    public String getFormattedAdjustmentsGrandTotalAmount() {
        return formattedAdjustmentsGrandTotalAmount;
    }

    public void setFormattedAdjustmentsGrandTotalAmount(String formattedAdjustmentsGrandTotalAmount) {
        this.formattedAdjustmentsGrandTotalAmount = formattedAdjustmentsGrandTotalAmount;
    }

    public String getFormattedAdjustmentsTaxAmount() {
        return formattedAdjustmentsTaxAmount;
    }

    public void setFormattedAdjustmentsTaxAmount(String formattedAdjustmentsTaxAmount) {
        this.formattedAdjustmentsTaxAmount = formattedAdjustmentsTaxAmount;
    }

    public String getFormattedCorrectionGrandTotalAmount() {
        return formattedCorrectionGrandTotalAmount;
    }

    public void setFormattedCorrectionGrandTotalAmount(String formattedCorrectionGrandTotalAmount) {
        this.formattedCorrectionGrandTotalAmount = formattedCorrectionGrandTotalAmount;
    }

    public String getFormattedRefundGrandTotalAmount() {
        return formattedRefundGrandTotalAmount;
    }

    public void setFormattedRefundGrandTotalAmount(String formattedRefundGrandTotalAmount) {
        this.formattedRefundGrandTotalAmount = formattedRefundGrandTotalAmount;
    }

    public String getFormattedTaxAmount() {
        return formattedTaxAmount;
    }

    public void setFormattedTaxAmount(String formattedTaxAmount) {
        this.formattedTaxAmount = formattedTaxAmount;
    }

    public String getFormattedCorrectionTaxAmount() {
        return formattedCorrectionTaxAmount;
    }

    public void setFormattedCorrectionTaxAmount(String formattedCorrectionTaxAmount) {
        this.formattedCorrectionTaxAmount = formattedCorrectionTaxAmount;
    }

    public List<FolioInvoiceLineItemView> getAdjustmentFolioLineItems() {
        return adjustmentFolioLineItems;
    }

    public void setAdjustmentFolioLineItems(List<FolioInvoiceLineItemView> adjustmentFolioLineItems) {
        this.adjustmentFolioLineItems = adjustmentFolioLineItems;
    }

    public List<FolioInvoiceLineItemView> getGroupedFolioTaxLineItems() {
        return groupedFolioTaxLineItems;
    }

    public void setGroupedFolioTaxLineItems(List<FolioInvoiceLineItemView> groupedFolioTaxLineItems) {
        this.groupedFolioTaxLineItems = groupedFolioTaxLineItems;
    }

    public List<FolioInvoiceLineItemView> getRefundFolioLineItems() {
        return refundFolioLineItems;
    }

    public void setRefundFolioLineItems(List<FolioInvoiceLineItemView> refundFolioLineItems) {
        this.refundFolioLineItems = refundFolioLineItems;
    }

    public List<FolioInvoiceLineItemView> getTaxFolioLineItems() {
        return taxFolioLineItems;
    }

    public void setTaxFolioLineItems(List<FolioInvoiceLineItemView> taxFolioLineItems) {
        this.taxFolioLineItems = taxFolioLineItems;
    }

    public FolioInvoiceLineItemView getCorrectionFolioLineItem() {
        return correctionFolioLineItem;
    }

    public void setCorrectionFolioLineItem(FolioInvoiceLineItemView correctionFolioLineItem) {
        this.correctionFolioLineItem = correctionFolioLineItem;
    }

    public LineItemView getTransferFolioLineItem() {
        return transferFolioLineItem;
    }

    public void setTransferFolioLineItem(LineItemView transferFolioLineItem) {
        this.transferFolioLineItem = transferFolioLineItem;
    }

    public boolean getShowReason() {
        return showReason;
    }

    public void setShowReason(boolean showReason) {
        this.showReason = showReason;
    }

    public FolioInvoiceLineItemView lineItemToFolioInvoiceViewLineItem(LineItemView lineItemView) {
        setTaxAmount(lineItemView.getTaxAmount());
        setTotalAmount(lineItemView.getTotalAmount());
        setGrandTotalAmount(lineItemView.getGrandTotalAmount());
        setLineItemChargesBalance(lineItemView.getLineItemChargesBalance());
        setLineItemBalance(lineItemView.getLineItemBalance());
        setLineItemTaxBalance(lineItemView.getLineItemTaxBalance());
        setQuantity(lineItemView.getQuantity());
        setAdjustmentsGrandTotalAmount(lineItemView.getAdjustmentsTotalAmount());
        setAdjustmentsTaxAmount(lineItemView.getAdjustmentsTaxAmount());
        setAdjustmentsTotalAmount(lineItemView.getAdjustmentsTotalAmount());
        setCorrectionGrandTotalAmount(lineItemView.getCorrectionGrandTotalAmount());
        setCorrectionTaxAmount(lineItemView.getCorrectionTaxAmount());
        setCorrectionTotalAmount(lineItemView.getCorrectionTotalAmount());
        setRefundGrantTotalAmount(lineItemView.getRefundGrantTotalAmount());
        setTransferGrandTotalAmount(lineItemView.getTransferGrandTotalAmount());
        setTransferTaxAmount(lineItemView.getTransferTaxAmount());
        setTransferTotalAmount(lineItemView.getTransferTotalAmount());
        setAccountId(lineItemView.getAccountId());
        setAutoRecurringItemId(lineItemView.getAutoRecurringItemId());
        setAutoRouted(lineItemView.isAutoRouted());
        setCallType(lineItemView.getCallType());
        setCategoryId(lineItemView.getCategoryId());
        setCompInfo(lineItemView.getCompInfo());
        setComponentType(lineItemView.getComponentType());
        setDescription(lineItemView.getDescription());
        setDisplayDate(lineItemView.getDisplayDate());
        setDistributed(lineItemView.isDistributed());
        setFolioId(lineItemView.getFolioId());
        setFolioLineType(lineItemView.getFolioLineType());
        setFreeAllowanceAmount(lineItemView.getFreeAllowanceAmount());
        setId(lineItemView.getId());
        setInvalid(lineItemView.isInvalid());
        setItemId(lineItemView.getItemId());
        setLedgerId(lineItemView.getLedgerId());
        setLedgerTransactionHistory(lineItemView.getLedgerTransactionHistory());
        setLedgerTransactionHistoryId(lineItemView.getLedgerTransactionHistoryId());
        setMealPeriodId(lineItemView.getMealPeriodId());
        setName(lineItemView.getName());
        setParentId(lineItemView.getParentId());
        setPetDisplayName(lineItemView.getPetDisplayName());
        setPostingCalendarDateTime(lineItemView.getPostingCalendarDateTime());
        setPostingPropertyDate(lineItemView.getPostingPropertyDate());
        setRateChangeComment(lineItemView.getRateChangeComment());
        setReason(lineItemView.getReason());
        setReceiptTextImage(lineItemView.getReceiptTextImage());
        setRecurringChargeId(lineItemView.getRecurringChargeId());
        setReference(lineItemView.getReference());
        setReservationId(lineItemView.getReservationId());
        setReverseTax(lineItemView.isReverseTax());
        setReverseTaxTotalChargeAmount(lineItemView.getReverseTaxTotalChargeAmount());
        setRoomChargePostingType(lineItemView.getRoomChargePostingType());
        setRoomRevenue(lineItemView.isRoomRevenue());
        setRouted(lineItemView.isRouted());
        setSourceId(lineItemView.getSourceId());
        setSubcategoryId(lineItemView.getSubcategoryId());
        setTransactionDestinationAccountId(lineItemView.getTransactionDestinationAccountId());
        setTransactionId(lineItemView.getTransactionId());
        setTransactionMessageAttributes(lineItemView.getTransactionMessageAttributes());
        setTransactionSourceAccountId(lineItemView.getTransactionSourceAccountId());
        setTransactionType(lineItemView.getTransactionType());
        setUnitAmount(lineItemView.getUnitAmount());
        setUserId(lineItemView.getUserId());
        setReverseTaxTotalChargeAmount(lineItemView.getReverseTaxTotalChargeAmount());
        setReverseTax(lineItemView.isReverseTax());
        return this;
    }
}
