package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.common.model.PaymentSetting;

public class AuthSummary {
    /**
     * The total available credit, calculated as the authorization amount minus the estimated charges at checkout
     */
    private BigDecimal totalAvailableCredit = BigDecimal.ZERO;

    /**
     * The amount of the current authorization for the {@link PaymentSetting}
     */
    private BigDecimal currentAuthAmount = BigDecimal.ZERO;

    /**
     * The total auth required minus the current auth
     */
    private BigDecimal additionalAuthRequired = BigDecimal.ZERO;

    /**
     * The total authorization required to cover the estimated charges at checkout plus any applicable per diems
     */
    private BigDecimal totalAuth = BigDecimal.ZERO;

    /**
     * The property configured per day per diem
     */
    private BigDecimal propertyAuthPerDay = BigDecimal.ZERO;

    /**
     * The property configured per adult per day per diem
     */
    private BigDecimal propertyAuthPerAdultPerDay = BigDecimal.ZERO;

    public BigDecimal getTotalAvailableCredit() {
        return totalAvailableCredit;
    }

    public void setTotalAvailableCredit(BigDecimal totalAvailableCredit) {
        this.totalAvailableCredit = totalAvailableCredit;
    }

    public BigDecimal getCurrentAuthAmount() {
        return currentAuthAmount;
    }

    public void setCurrentAuthAmount(BigDecimal currentAuthAmount) {
        this.currentAuthAmount = currentAuthAmount;
    }

    public BigDecimal getAdditionalAuthRequired() {
        return additionalAuthRequired;
    }

    public void setAdditionalAuthRequired(BigDecimal additionalAuthRequired) {
        this.additionalAuthRequired = additionalAuthRequired;
    }

    public BigDecimal getTotalAuth() {
        return totalAuth;
    }

    public void setTotalAuth(BigDecimal totalAuth) {
        this.totalAuth = totalAuth;
    }

    public BigDecimal getPropertyAuthPerDay() {
        return propertyAuthPerDay;
    }

    public void setPropertyAuthPerDay(BigDecimal propertyAuthPerDay) {
        this.propertyAuthPerDay = propertyAuthPerDay;
    }

    public BigDecimal getPropertyAuthPerAdultPerDay() {
        return propertyAuthPerAdultPerDay;
    }

    public void setPropertyAuthPerAdultPerDay(BigDecimal propertyAuthPerAdultPerDay) {
        this.propertyAuthPerAdultPerDay = propertyAuthPerAdultPerDay;
    }
}
