package com.agilysys.pms.account.data.domain;

import java.math.BigDecimal;

public class CheckAllowanceResponse {
    private BigDecimal remainingAllowance;
    private BigDecimal breakage;
    private BigDecimal usedAllowance;

    public CheckAllowanceResponse() {}

    public CheckAllowanceResponse(BigDecimal remainingAllowance, BigDecimal breakage, BigDecimal usedAllowance) {
        this.breakage = breakage;
        this.remainingAllowance = remainingAllowance;
        this.usedAllowance = usedAllowance;
    }

    public BigDecimal getRemainingAllowance() {
        return remainingAllowance;
    }

    public void setRemainingAllowance(BigDecimal remainingAllowance) {
        this.remainingAllowance = remainingAllowance;
    }

    public BigDecimal getBreakage() {
        return breakage;
    }

    public void setBreakage(BigDecimal breakage) {
        this.breakage = breakage;
    }

    public BigDecimal getUsedAllowance() {
        return usedAllowance;
    }

    public void setUsedAllowance(BigDecimal usedAllowance) {
        this.usedAllowance = usedAllowance;
    }
}