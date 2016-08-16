package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class GroupSummary {
    private BigDecimal chargesCount;
    private BigDecimal totalCharge;
    private BigDecimal totaltax;
    private BigDecimal totalPayments;
    private BigDecimal totalBalance;

    public BigDecimal getChargesCount() {
        return chargesCount;
    }

    public void setChargesCount(BigDecimal chargesCount) {
        this.chargesCount = chargesCount;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotaltax() {
        return totaltax;
    }

    public void setTotaltax(BigDecimal totaltax) {
        this.totaltax = totaltax;
    }

    public BigDecimal getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(BigDecimal totalPayments) {
        this.totalPayments = totalPayments;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }
}
