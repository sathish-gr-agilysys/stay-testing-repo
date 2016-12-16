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

    /**
     * Total of posted room charges
     */
    @Deprecated
    private BigDecimal roomPostedCharges = BigDecimal.ZERO;

    /**
     * Total of future, non-room charges
     */
    @Deprecated
    private BigDecimal futureCharges = BigDecimal.ZERO;

    /**
     * Total of posted, non-room charges
     */
    @Deprecated
    private BigDecimal postedCharges = BigDecimal.ZERO;

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

    /**
     * Gets the total of future, non-room charges
     */
    @Deprecated
    public BigDecimal getFutureCharges() {
        return futureCharges;
    }

    /**
     * Sets the total of future, non-room charges
     */
    @Deprecated
    public void setFutureCharges(BigDecimal futureCharges) {
        this.futureCharges = futureCharges;
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

    /**
     * Gets the total of posted, non-room charges
     */
    @Deprecated
    public BigDecimal getPostedCharges() {
        return postedCharges;
    }

    /**
     * Sets the total of posted, non-room charges
     */
    @Deprecated
    public void setPostedCharges(BigDecimal postedCharges) {
        this.postedCharges = postedCharges;
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

    /**
     * Gets the total of posted room charges
     */
    @Deprecated
    public BigDecimal getRoomPostedCharges() {
        return roomPostedCharges;
    }

    /**
     * Sets the total of posted room charges
     */
    @Deprecated
    public void setRoomPostedCharges(BigDecimal roomPostedCharges) {
        this.roomPostedCharges = roomPostedCharges;
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
