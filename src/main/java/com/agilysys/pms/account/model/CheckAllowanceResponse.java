package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class CheckAllowanceResponse {
    private BigDecimal remainingAllowance;
    private BigDecimal breakage;
    private BigDecimal usedAllowance;
    private boolean applicable = true;
    private boolean allowanceComponent = true;
    private String componentId;

    public CheckAllowanceResponse() {}

    public CheckAllowanceResponse(BigDecimal remainingAllowance, BigDecimal breakage, BigDecimal usedAllowance) {
        this.breakage = breakage;
        this.remainingAllowance = remainingAllowance;
        this.usedAllowance = usedAllowance;
    }

    public CheckAllowanceResponse(boolean allowanceComponent, boolean applicable) {
        this.allowanceComponent = allowanceComponent;
        this.applicable = applicable;
    }

    public CheckAllowanceResponse(boolean allowanceComponent, boolean applicable, String componentId) {
        this(allowanceComponent, applicable);
        this.componentId = componentId;
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

    public boolean isApplicable() {
        return applicable;
    }

    public void setApplicable(boolean applicable) {
        this.applicable = applicable;
    }

    public boolean isAllowanceComponent() {
        return allowanceComponent;
    }

    public void setAllowanceComponent(boolean allowanceComponent) {
        this.allowanceComponent = allowanceComponent;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }
}