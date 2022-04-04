package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

public class PackageFolioDetails {

    private String accountId;
    private String reservationId;
    private LocalDate availabilityDate;
    private BigDecimal remainingAllowance;
    private BigDecimal breakage;
    private BigDecimal usedAllowance;
    private String componentId;
    private String tenantId;
    private String propertyId;

    public PackageFolioDetails(){}

    public PackageFolioDetails(String tenantId, String propertyId, String accountId, String reservationId,
          LocalDate availabilityDate, BigDecimal remainingAllowance, BigDecimal breakage, BigDecimal usedAllowance,
          String componentId) {
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.accountId = accountId;
        this.reservationId = reservationId;
        this.availabilityDate = availabilityDate;
        this.remainingAllowance = remainingAllowance;
        this.breakage = breakage;
        this.usedAllowance = usedAllowance;
        this.componentId = componentId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
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

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }
}
