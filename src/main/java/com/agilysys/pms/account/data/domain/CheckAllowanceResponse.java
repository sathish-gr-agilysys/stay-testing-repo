package com.agilysys.pms.account.data.domain;

import java.math.BigDecimal;

public class CheckAllowanceResponse {
    private BigDecimal availableAllowance;
    private BigDecimal breakage;
    private BigDecimal usedAllowance;

    public CheckAllowanceResponse() {}

    public CheckAllowanceResponse(BigDecimal availableAllowance, BigDecimal breakage, BigDecimal usedAllowance) {
        this.breakage = breakage;
        this.availableAllowance = availableAllowance;
        this.usedAllowance = usedAllowance;
    }

    public BigDecimal getAvailableAllowance() {
        return availableAllowance;
    }

    public void setAvailableAllowance(BigDecimal availableAllowance) {
        this.availableAllowance = availableAllowance;
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