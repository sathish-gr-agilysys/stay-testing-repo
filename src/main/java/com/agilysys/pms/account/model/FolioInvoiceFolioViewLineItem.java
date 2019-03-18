/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class FolioInvoiceFolioViewLineItem extends FolioInvoiceLineItemView {

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

    private String totalAmounts;
    private String taxAmounts;
    private String refundGrantTotalAmounts;
    private String grandTotalAmounts;
    private String adjustmentsTotalAmounts;
    private String adjustmentsTaxAmounts;
    private String adjustmentsGrandTotalAmounts;
    private String transferTotalAmounts;
    private String transferTaxAmounts;
    private String transferGrandTotalAmounts;
    private String correctionTotalAmounts;
    private String correctionTaxAmounts;
    private String correctionGrandTotalAmounts;
    private String lineItemTaxBalances;
    private String lineItemChargesBalances;
    private String lineItemBalances;
    private GroupSummary groupSummarys;
    private boolean showReason;

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

    public String getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(String totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public String getTaxAmounts() {
        return taxAmounts;
    }

    public void setTaxAmounts(String taxAmounts) {
        this.taxAmounts = taxAmounts;
    }

    public String getRefundGrantTotalAmounts() {
        return refundGrantTotalAmounts;
    }

    public void setRefundGrantTotalAmounts(String refundGrantTotalAmounts) {
        this.refundGrantTotalAmounts = refundGrantTotalAmounts;
    }

    public String getGrandTotalAmounts() {
        return grandTotalAmounts;
    }

    public void setGrandTotalAmounts(String grandTotalAmounts) {
        this.grandTotalAmounts = grandTotalAmounts;
    }

    public String getAdjustmentsTotalAmounts() {
        return adjustmentsTotalAmounts;
    }

    public void setAdjustmentsTotalAmounts(String adjustmentsTotalAmounts) {
        this.adjustmentsTotalAmounts = adjustmentsTotalAmounts;
    }

    public String getAdjustmentsTaxAmounts() {
        return adjustmentsTaxAmounts;
    }

    public void setAdjustmentsTaxAmounts(String adjustmentsTaxAmounts) {
        this.adjustmentsTaxAmounts = adjustmentsTaxAmounts;
    }

    public String getAdjustmentsGrandTotalAmounts() {
        return adjustmentsGrandTotalAmounts;
    }

    public void setAdjustmentsGrandTotalAmounts(String adjustmentsGrandTotalAmounts) {
        this.adjustmentsGrandTotalAmounts = adjustmentsGrandTotalAmounts;
    }

    public String getTransferTotalAmounts() {
        return transferTotalAmounts;
    }

    public void setTransferTotalAmounts(String transferTotalAmounts) {
        this.transferTotalAmounts = transferTotalAmounts;
    }

    public String getTransferTaxAmounts() {
        return transferTaxAmounts;
    }

    public void setTransferTaxAmounts(String transferTaxAmounts) {
        this.transferTaxAmounts = transferTaxAmounts;
    }

    public String getTransferGrandTotalAmounts() {
        return transferGrandTotalAmounts;
    }

    public void setTransferGrandTotalAmounts(String transferGrandTotalAmounts) {
        this.transferGrandTotalAmounts = transferGrandTotalAmounts;
    }

    public String getCorrectionTotalAmounts() {
        return correctionTotalAmounts;
    }

    public void setCorrectionTotalAmounts(String correctionTotalAmounts) {
        this.correctionTotalAmounts = correctionTotalAmounts;
    }

    public String getCorrectionTaxAmounts() {
        return correctionTaxAmounts;
    }

    public void setCorrectionTaxAmounts(String correctionTaxAmounts) {
        this.correctionTaxAmounts = correctionTaxAmounts;
    }

    public String getCorrectionGrandTotalAmounts() {
        return correctionGrandTotalAmounts;
    }

    public void setCorrectionGrandTotalAmounts(String correctionGrandTotalAmounts) {
        this.correctionGrandTotalAmounts = correctionGrandTotalAmounts;
    }

    public String getLineItemTaxBalances() {
        return lineItemTaxBalances;
    }

    public void setLineItemTaxBalances(String lineItemTaxBalances) {
        this.lineItemTaxBalances = lineItemTaxBalances;
    }

    public String getLineItemChargesBalances() {
        return lineItemChargesBalances;
    }

    public void setLineItemChargesBalances(String lineItemChargesBalances) {
        this.lineItemChargesBalances = lineItemChargesBalances;
    }

    public String getLineItemBalances() {
        return lineItemBalances;
    }

    public void setLineItemBalances(String lineItemBalances) {
        this.lineItemBalances = lineItemBalances;
    }

    public GroupSummary getGroupSummarys() {
        return groupSummarys;
    }

    public void setGroupSummarys(GroupSummary groupSummarys) {
        this.groupSummarys = groupSummarys;
    }

    public boolean isShowReason() {
        return showReason;
    }

    public void setShowReason(boolean showReason) {
        this.showReason = showReason;
    }
}
