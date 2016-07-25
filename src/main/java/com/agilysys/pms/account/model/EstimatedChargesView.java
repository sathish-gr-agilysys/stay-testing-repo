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
     * Total of future taxes, for both room and non-room charges
     */
    @Deprecated
    private BigDecimal futureTaxes = BigDecimal.ZERO;

    /**
     * Total of posted, non-room charges
     */
    @Deprecated
    private BigDecimal postedCharges = BigDecimal.ZERO;

    /**
     * Total of posted payments (as a negative number)
     */
    @Deprecated
    private BigDecimal postedPayments = BigDecimal.ZERO;

    /**
     * Total of posted taxes, for both room and non-room charges
     */
    @Deprecated
    private BigDecimal postedTaxes = BigDecimal.ZERO;

    /**
     * Total taxes, for all of posted and future, room and non-room charges
     */
    @Deprecated
    private BigDecimal taxes = BigDecimal.ZERO;

    /**
     * Total cost, including all charges and taxes
     */
    @Deprecated
    private BigDecimal total = BigDecimal.ZERO;

    /**
     * Total remaining cost (total plus posted payments)
     */
    @Deprecated
    private BigDecimal estimatedAtCheckout = BigDecimal.ZERO;

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

    /**
     * Gets the total of future taxes, for both room and non-room charges
     */
    @Deprecated
    public BigDecimal getFutureTaxes() {
        return futureTaxes;
    }

    /**
     * Sets the total of future taxes, for both room and non-room charges
     */
    @Deprecated
    public void setFutureTaxes(BigDecimal futureTaxes) {
        this.futureTaxes = futureTaxes;
    }

    /**
     * Gets the total cost, including all charges and taxes
     */
    @Deprecated
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets the total cost, including all charges and taxes
     */
    @Deprecated
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * Gets the total remaining cost (total plus posted payments)
     */
    @Deprecated
    public BigDecimal getEstimatedAtCheckout() {
        return estimatedAtCheckout;
    }

    /**
     * Sets the total remaining cost (total plus posted payments)
     */
    @Deprecated
    public void setEstimatedAtCheckout(BigDecimal estimatedAtCheckout) {
        this.estimatedAtCheckout = estimatedAtCheckout;
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

    /**
     * Gets the total of posted payments (as a negative number)
     */
    @Deprecated
    public BigDecimal getPostedPayments() {
        return postedPayments;
    }

    /**
     * Sets the total of posted payments (as a negative number)
     */
    @Deprecated
    public void setPostedPayments(BigDecimal postedPayments) {
        this.postedPayments = postedPayments;
    }

    /**
     * Gets the total of posted taxes, for both room and non-room charges
     */
    @Deprecated
    public BigDecimal getPostedTaxes() {
        return postedTaxes;
    }

    /**
     * Sets the total of posted taxes, for both room and non-room charges
     */
    @Deprecated
    public void setPostedTaxes(BigDecimal postedTaxes) {
        this.postedTaxes = postedTaxes;
    }

    /**
     * Gets the total taxes, for all of posted and future, room and non-room charges
     */
    @Deprecated
    public BigDecimal getTaxes() {
        return taxes;
    }

    /**
     * Sets the total taxes, for all of posted and future, room and non-room charges
     */
    @Deprecated
    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
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
