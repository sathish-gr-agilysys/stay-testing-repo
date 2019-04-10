package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class Summation {
    BigDecimal lineTotalAmount;
    BigDecimal grandTotalAmount;
    BigDecimal totalAmount;
    BigDecimal transferGrandTotalAmount;
    BigDecimal correctionGrandTotalAmount;
    BigDecimal adjustmentsGrandTotalAmount;
    BigDecimal refundGrandTotalAmount;
    BigDecimal taxAmount;
    BigDecimal adjustmentsTaxAmount;
    BigDecimal correctionTaxAmount;
    List<LineItemView> groupTax;
    List<LineItemView> transferLines;
    List<LineItemView> refundLines;
    List<LineItemView> adjustmentLines;
    List<LineItemView> correctionLines;
    boolean flagged;

    public Summation(BigDecimal lineTotalAmount, BigDecimal grandTotalAmount, BigDecimal amount, BigDecimal transfer, BigDecimal correction, BigDecimal adjustment, BigDecimal refund, BigDecimal tax, BigDecimal adjustmentTax,
          BigDecimal correctionTaxAmount, List<LineItemView> groupTax) {
        this.totalAmount = amount;
        this.transferGrandTotalAmount = transfer;
        this.correctionGrandTotalAmount = correction;
        this.adjustmentsGrandTotalAmount = adjustment;
        this.refundGrandTotalAmount = refund;
        this.taxAmount = tax;
        this.adjustmentsTaxAmount = adjustmentTax;
        this.correctionTaxAmount = correctionTaxAmount;
        this.grandTotalAmount = grandTotalAmount;
        this.groupTax = groupTax;
        this.lineTotalAmount = lineTotalAmount;
    }

    public BigDecimal getGrandTotalAmount() {
        return grandTotalAmount;
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    public BigDecimal getTransferGrandTotalAmount() {
        return transferGrandTotalAmount;
    }

    public void setTransferGrandTotalAmount(BigDecimal transferGrandTotalAmount) {
        this.transferGrandTotalAmount = transferGrandTotalAmount;
    }

    public BigDecimal getCorrectionGrandTotalAmount() {
        return correctionGrandTotalAmount;
    }

    public void setCorrectionGrandTotalAmount(BigDecimal correctionGrandTotalAmount) {
        this.correctionGrandTotalAmount = correctionGrandTotalAmount;
    }

    public BigDecimal getAdjustmentsGrandTotalAmount() {
        return adjustmentsGrandTotalAmount;
    }

    public void setAdjustmentsGrandTotalAmount(BigDecimal adjustmentsGrandTotalAmount) {
        this.adjustmentsGrandTotalAmount = adjustmentsGrandTotalAmount;
    }

    public BigDecimal getRefundGrandTotalAmount() {
        return refundGrandTotalAmount;
    }

    public void setRefundGrandTotalAmount(BigDecimal refundGrandTotalAmount) {
        this.refundGrandTotalAmount = refundGrandTotalAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getAdjustmentsTaxAmount() {
        return adjustmentsTaxAmount;
    }

    public void setAdjustmentsTaxAmount(BigDecimal adjustmentsTaxAmount) {
        this.adjustmentsTaxAmount = adjustmentsTaxAmount;
    }

    public BigDecimal getCorrectionTaxAmount() {
        return correctionTaxAmount;
    }

    public void setCorrectionTaxAmount(BigDecimal correctionTaxAmount) {
        this.correctionTaxAmount = correctionTaxAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public List<LineItemView> getGroupTax() {
        return groupTax;
    }

    public void setGroupTax(List<LineItemView> groupTax) {
        this.groupTax = groupTax;
    }

    public List<LineItemView> getTransferLines() {
        return transferLines;
    }

    public void setTransferLines(List<LineItemView> transferLines) {
        this.transferLines = transferLines;
    }

    public List<LineItemView> getRefundLines() {
        return refundLines;
    }

    public void setRefundLines(List<LineItemView> refundLines) {
        this.refundLines = refundLines;
    }

    public List<LineItemView> getCorrectionLines() {
        return correctionLines;
    }

    public void setCorrectionLines(List<LineItemView> correctionLines) {
        this.correctionLines = correctionLines;
    }

    public List<LineItemView> getAdjustmentLines() {
        return adjustmentLines;
    }

    public void setAdjustmentLines(List<LineItemView> adjustmentLines) {
        this.adjustmentLines = adjustmentLines;
    }

    public BigDecimal getLineTotalAmount() {
        return lineTotalAmount;
    }

    public void setLineTotalAmount(BigDecimal lineTotalAmount) {
        this.lineTotalAmount = lineTotalAmount;
    }
}