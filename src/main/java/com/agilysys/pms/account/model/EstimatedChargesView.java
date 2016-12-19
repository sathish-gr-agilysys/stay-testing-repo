/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Describes estimated charges for an account
 */
public class EstimatedChargesView {
    private List<RecurringChargeView> recurringCharges = new ArrayList<>();
    private BigDecimal roomRate = BigDecimal.ZERO;
    private Boolean isForDefaultFolio = Boolean.FALSE;

    /**
     * Total of room charges, both posted and future
     */
    @Deprecated
    private BigDecimal roomTotal = BigDecimal.ZERO;

    private Boolean thirdParty;
    private String paymentSettingId;

    private String rateCode;

    private EstimatedChargesSummaryView summary;

    /**
     * Gets the total of room charges, both posted and future
     */
    @Deprecated
    public BigDecimal getRoomTotal() {
        return roomTotal;
    }

    /**
     * Sets the total of room charges, both posted and future
     */
    @Deprecated
    public void setRoomTotal(BigDecimal roomTotal) {
        this.roomTotal = roomTotal;
    }

    public BigDecimal getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(BigDecimal roomRate) {
        this.roomRate = roomRate;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }


    public List<RecurringChargeView> getRecurringCharges() {
        return recurringCharges;
    }

    public void setRecurringCharges(List<RecurringChargeView> recurringCharges) {
        this.recurringCharges = recurringCharges;
    }

    public Boolean getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(Boolean thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getPaymentSettingId() {
        return paymentSettingId;
    }

    public void setPaymentSettingId(String paymentSettingId) {
        this.paymentSettingId = paymentSettingId;
    }


    public EstimatedChargesSummaryView getSummary() {
        return summary;
    }

    public void setSummary(EstimatedChargesSummaryView summary) {
        this.summary = summary;
    }

    /**
     * @return the isForDefaultFolio
     */
    public Boolean getIsForDefaultFolio() {
        return isForDefaultFolio;
    }

    /**
     * @param isForDefaultFolio the isForDefaultFolio to set
     */
    public void setIsForDefaultFolio(Boolean isForDefaultFolio) {
        this.isForDefaultFolio = isForDefaultFolio;
    }

}
