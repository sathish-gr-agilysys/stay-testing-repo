/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class OfferEstimatedSummary {

    private String offerId;

    private BigDecimal estimatedChargesOfferAmount;

    private BigDecimal estimatedTaxOfferAmount;

    private BigDecimal estimatedTotalOfferAmount;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public BigDecimal getEstimatedChargesOfferAmount() {
        return estimatedChargesOfferAmount;
    }

    public void setEstimatedChargesOfferAmount(BigDecimal estimatedChargesOfferAmount) {
        this.estimatedChargesOfferAmount = estimatedChargesOfferAmount;
    }

    public BigDecimal getEstimatedTaxOfferAmount() {
        return estimatedTaxOfferAmount;
    }

    public void setEstimatedTaxOfferAmount(BigDecimal estimatedTaxOfferAmount) {
        this.estimatedTaxOfferAmount = estimatedTaxOfferAmount;
    }

    public BigDecimal getEstimatedTotalOfferAmount() {
        return estimatedTotalOfferAmount;
    }

    public void setEstimatedTotalOfferAmount(BigDecimal estimatedTotalOfferAmount) {
        this.estimatedTotalOfferAmount = estimatedTotalOfferAmount;
    }
}