package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class FolioViewLineItem extends LineItemView {

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
    private BigDecimal lineItemTaxBalance;
    private BigDecimal lineItemChargesBalance;
    private BigDecimal lineItemBalance;
    private GroupSummary groupSummary;

    @Override
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Override
    public BigDecimal getRefundGrantTotalAmount() {
        return refundGrantTotalAmount;
    }

    public void setRefundGrantTotalAmount(BigDecimal refundGrantTotalAmount) {
        this.refundGrantTotalAmount = refundGrantTotalAmount;
    }

    @Override
    public BigDecimal getGrandTotalAmount() {
        return grandTotalAmount;
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    @Override
    public BigDecimal getAdjustmentsTaxAmount() {
        return adjustmentsTaxAmount;
    }

    public void setAdjustmentsTaxAmount(BigDecimal adjustmentsTaxAmount) {
        this.adjustmentsTaxAmount = adjustmentsTaxAmount;
    }

    @Override
    public BigDecimal getAdjustmentsGrandTotalAmount() {
        return adjustmentsGrandTotalAmount;
    }

    public void setAdjustmentsGrandTotalAmount(BigDecimal adjustmentsGrandTotalAmount) {
        this.adjustmentsGrandTotalAmount = adjustmentsGrandTotalAmount;
    }

    @Override
    public BigDecimal getTransferTotalAmount() {
        return transferTotalAmount;
    }

    public void setTransferTotalAmount(BigDecimal transferTotalAmount) {
        this.transferTotalAmount = transferTotalAmount;
    }

    @Override
    public BigDecimal getTransferTaxAmount() {
        return transferTaxAmount;
    }

    public void setTransferTaxAmount(BigDecimal transferTaxAmount) {
        this.transferTaxAmount = transferTaxAmount;
    }

    @Override
    public BigDecimal getTransferGrandTotalAmount() {
        return transferGrandTotalAmount;
    }

    public void setTransferGrandTotalAmount(BigDecimal transferGrandTotalAmount) {
        this.transferGrandTotalAmount = transferGrandTotalAmount;
    }

    @Override
    public BigDecimal getCorrectionTotalAmount() {
        return correctionTotalAmount;
    }

    public void setCorrectionTotalAmount(BigDecimal correctionTotalAmount) {
        this.correctionTotalAmount = correctionTotalAmount;
    }

    @Override
    public BigDecimal getCorrectionTaxAmount() {
        return correctionTaxAmount;
    }

    public void setCorrectionTaxAmount(BigDecimal correctionTaxAmount) {
        this.correctionTaxAmount = correctionTaxAmount;
    }

    @Override
    public BigDecimal getCorrectionGrandTotalAmount() {
        return correctionGrandTotalAmount;
    }

    public void setCorrectionGrandTotalAmount(BigDecimal correctionGrandTotalAmount) {
        this.correctionGrandTotalAmount = correctionGrandTotalAmount;
    }

    @Override
    public BigDecimal getLineItemTaxBalance() {
        return lineItemTaxBalance;
    }

    public void setLineItemTaxBalance(BigDecimal lineItemTaxBalance) {
        this.lineItemTaxBalance = lineItemTaxBalance;
    }

    @Override
    public BigDecimal getLineItemChargesBalance() {
        return lineItemChargesBalance;
    }

    public void setLineItemChargesBalance(BigDecimal lineItemChargesBalance) {
        this.lineItemChargesBalance = lineItemChargesBalance;
    }

    @Override
    public BigDecimal getLineItemBalance() {
        return lineItemBalance;
    }

    public void setLineItemBalance(BigDecimal lineItemBalance) {
        this.lineItemBalance = lineItemBalance;
    }

    @Override
    public BigDecimal getAdjustmentsTotalAmount() {
        return adjustmentsTotalAmount;
    }

    public void setAdjustmentsTotalAmount(BigDecimal adjustmentsTotalAmount) {
        this.adjustmentsTotalAmount = adjustmentsTotalAmount;
    }

    public GroupSummary getGroupSummary() {
        return groupSummary;
    }

    public void setGroupSummary(GroupSummary groupSummary) {
        this.groupSummary = groupSummary;
    }

}
