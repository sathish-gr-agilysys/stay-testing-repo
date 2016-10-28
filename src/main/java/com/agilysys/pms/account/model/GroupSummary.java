/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class GroupSummary {
    private int chargesCount;
    private BigDecimal totalCharge;
    private BigDecimal totalTax;
    private BigDecimal totalAmount;
    private BigDecimal totalRefund;
    private BigDecimal totalAdjustment;
    private BigDecimal totalCorrection;
    private BigDecimal totalPayment;
    private boolean distributedCharge;
    private String distributedChargeName;

    public BigDecimal getTotalCorrection() {
        return totalCorrection;
    }

    public void setTotalCorrection(BigDecimal totalCorrection) {
        this.totalCorrection = totalCorrection;
    }

    public int getChargesCount() {
        return chargesCount;
    }

    public void setChargesCount(int chargesCount) {
        this.chargesCount = chargesCount;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(BigDecimal totalRefund) {
        this.totalRefund = totalRefund;
    }

    public BigDecimal getTotalAdjustment() {
        return totalAdjustment;
    }

    public void setTotalAdjustment(BigDecimal totalAdjustment) {
        this.totalAdjustment = totalAdjustment;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayments) {
        this.totalPayment = totalPayments;
    }

    public boolean isDistributedCharge() {
        return distributedCharge;
    }

    public void setDistributedCharge(boolean distributedCharge) {
        this.distributedCharge = distributedCharge;
    }

    public String getDistributedChargeName() {
        return distributedChargeName;
    }

    public void setDistributedChargeName(String distributedChargeName) {
        this.distributedChargeName = distributedChargeName;
    }
}
