/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.LocalDate;

public abstract class InvoiceFolioLineView<T extends InvoiceFolioLineView<T>> {
    private String description;
    private LocalDate displayDate;
    private String reason;
    private BigDecimal taxAmount;
    private BigDecimal totalAmount;

    private List<T> adjustmentLineItems;
    private T correctionLineItem;
    private List<T> refundLineItems;
    private List<T> taxLineItems;
    private T transferLineItem;
    private Map<String, String> transactionMessageAttributes;
    private String transactionType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<T> getAdjustmentLineItems() {
        return adjustmentLineItems;
    }

    public void setAdjustmentLineItems(List<T> adjustmentLineItems) {
        this.adjustmentLineItems = adjustmentLineItems;
    }

    public T getCorrectionLineItem() {
        return correctionLineItem;
    }

    public void setCorrectionLineItem(T correctionLineItem) {
        this.correctionLineItem = correctionLineItem;
    }

    public List<T> getRefundLineItems() {
        return refundLineItems;
    }

    public void setRefundLineItems(List<T> refundLineItems) {
        this.refundLineItems = refundLineItems;
    }

    public List<T> getTaxLineItems() {
        return taxLineItems;
    }

    public void setTaxLineItems(List<T> taxLineItems) {
        this.taxLineItems = taxLineItems;
    }

    public T getTransferLineItem() {
        return transferLineItem;
    }

    public void setTransferLineItem(T transferLineItem) {
        this.transferLineItem = transferLineItem;
    }

    public BigDecimal getLineItemBalance() {
        BigDecimal totalAmount = getGrandTotalAmount();
        totalAmount = add(totalAmount, getAdjustmentsGrandTotalAmount());
        totalAmount = add(totalAmount, getTransferGrandTotalAmount());
        totalAmount = add(totalAmount, getCorrectionGrandTotalAmount());
        totalAmount = add(totalAmount, getRefundGrantTotalAmount());

        return totalAmount;
    }

    public BigDecimal getLineItemChargesBalance() {
        BigDecimal totalAmount = getTotalAmount();
        totalAmount = add(totalAmount, getAdjustmentsTotalAmount());
        totalAmount = add(totalAmount, getTransferTotalAmount());
        totalAmount = add(totalAmount, getCorrectionTotalAmount());
        totalAmount = add(totalAmount, getRefundGrantTotalAmount());

        return totalAmount;
    }

    public BigDecimal getLineItemTaxBalance() {
        BigDecimal totalAmount = getTaxAmount();
        totalAmount = add(totalAmount, getAdjustmentsTaxAmount());
        totalAmount = add(totalAmount, getTransferTaxAmount());
        totalAmount = add(totalAmount, getCorrectionTaxAmount());

        return totalAmount;
    }

    public BigDecimal getGrandTotalAmount() {
        return totalAmount.add(taxAmount);
    }

    public BigDecimal getAdjustmentsGrandTotalAmount() {
        BigDecimal totalAmount = getAdjustmentsTotalAmount();
        return totalAmount != null ? add(totalAmount, getAdjustmentsTaxAmount()) : null;
    }

    public BigDecimal getTransferGrandTotalAmount() {
        BigDecimal totalAmount = getTransferTotalAmount();
        return totalAmount != null ? add(totalAmount, getTransferTaxAmount()) : null;
    }

    public BigDecimal getCorrectionGrandTotalAmount() {
        BigDecimal totalAmount = getCorrectionTotalAmount();
        return totalAmount != null ? add(totalAmount, getCorrectionTaxAmount()) : null;
    }

    public BigDecimal getRefundGrantTotalAmount() {
        if (CollectionUtils.isEmpty(refundLineItems)) {
            return null;
        }

        BigDecimal refundAmount = BigDecimal.ZERO;
        for (T refund : refundLineItems) {
            refundAmount = refundAmount.add(refund.getGrandTotalAmount());
        }

        return refundAmount;
    }

    public BigDecimal getCorrectionTaxAmount() {
        return correctionLineItem != null ? correctionLineItem.getTaxAmount() : null;
    }

    public BigDecimal getCorrectionTotalAmount() {
        return correctionLineItem != null ? correctionLineItem.getTotalAmount() : null;
    }

    public BigDecimal getTransferTaxAmount() {
        return transferLineItem != null ? transferLineItem.getTaxAmount() : null;
    }

    public BigDecimal getTransferTotalAmount() {
        return transferLineItem != null ? transferLineItem.getTotalAmount() : null;
    }

    public Map<String, String> getTransactionMessageAttributes() {
        return transactionMessageAttributes;
    }

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAdjustmentsTotalAmount() {
        if (CollectionUtils.isEmpty(adjustmentLineItems)) {
            return null;
        }

        BigDecimal adjustmentsTotalAmount = BigDecimal.ZERO;
        for (T adjustment : adjustmentLineItems) {
            adjustmentsTotalAmount = adjustmentsTotalAmount.add(adjustment.getTotalAmount());
        }

        return adjustmentsTotalAmount;
    }

    public BigDecimal getAdjustmentsTaxAmount() {
        if (CollectionUtils.isEmpty(adjustmentLineItems)) {
            return null;
        }

        BigDecimal adjustmentsTaxAmount = BigDecimal.ZERO;
        for (T adjustment : getAdjustmentLineItems()) {
            adjustmentsTaxAmount = adjustmentsTaxAmount.add(adjustment.getTaxAmount());
        }

        return adjustmentsTaxAmount;
    }

    private BigDecimal add(BigDecimal amount, BigDecimal amountToAdd) {
        return amountToAdd != null ? amount.add(amountToAdd) : amount;
    }
}
