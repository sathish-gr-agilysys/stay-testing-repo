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
    private String adjustedMessage;
    private String refundMessage;
    private String transferOutTransactionMessage;
    private String correctionMessage;
    private String correctedMessage;
    private String creditMessage;
    private String balanceTransferMessage;
    private String transferInMessage;
    private String formattedUnitAmount;
    private boolean showReason;
    private List<FolioInvoiceLineItemView> adjustmentFolioLineItems;
    private List<FolioInvoiceLineItemView> groupedFolioTaxLineItems;
    private List<FolioInvoiceLineItemView> refundFolioLineItems;
    private List<FolioInvoiceLineItemView> taxFolioLineItems;
    private FolioInvoiceLineItemView correctionFolioLineItem;
    private FolioInvoiceLineItemView transferFolioLineItem;

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

    public String getAdjusteddMessage() {
        return adjustedMessage;
    }

    public void setAdjustedMessage(String adjustedMessage) {
        this.adjustedMessage = adjustedMessage;
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

    public String getFormattedUnitAmount() {
        return formattedUnitAmount;
    }

    public void setFormattedUnitAmount(String formattedUnitAmount) {
        this.formattedUnitAmount = formattedUnitAmount;
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

    public FolioInvoiceLineItemView getTransferFolioLineItem() {
        return transferFolioLineItem;
    }

    public void setTransferFolioLineItem(FolioInvoiceLineItemView transferFolioLineItem) {
        this.transferFolioLineItem = transferFolioLineItem;
    }

    public boolean getShowReason() {
        return showReason;
    }

    public void setShowReason(boolean showReason) {
        this.showReason = showReason;
    }
}
