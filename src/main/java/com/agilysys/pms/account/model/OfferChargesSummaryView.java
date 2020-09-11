/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OfferChargesSummaryView {
    BigDecimal offerTotalAmount;
    BigDecimal offerTotalTax;
    BigDecimal estimatedChargesWithOffer;
    BigDecimal estimatedTaxesWithOffer;
    BigDecimal estimatedRoomChargesWithOffer = BigDecimal.ZERO;

    public BigDecimal getOfferTotalAmount() {
        return offerTotalAmount;
    }

    public void setOfferTotalAmount(BigDecimal offerTotalAmount) {
        this.offerTotalAmount = offerTotalAmount;
    }

    public BigDecimal getOfferTotalTax() {
        return offerTotalTax;
    }

    public void setOfferTotalTax(BigDecimal offerTotalTax) {
        this.offerTotalTax = offerTotalTax;
    }

    public BigDecimal getEstimatedChargesWithOffer() {
        return estimatedChargesWithOffer;
    }

    public void setEstimatedChargesWithOffer(BigDecimal estimatedChargesWithOffer) {
        this.estimatedChargesWithOffer = estimatedChargesWithOffer;
    }

    public BigDecimal getEstimatedTaxesWithOffer() {
        return estimatedTaxesWithOffer;
    }

    public void setEstimatedTaxesWithOffer(BigDecimal estimatedTaxesWithOffer) {
        this.estimatedTaxesWithOffer = estimatedTaxesWithOffer;
    }

    private List<OfferEstimatedSummary> offerSummaries = new ArrayList<>();

    public List<OfferEstimatedSummary> getOfferSummaries() {
        return offerSummaries;
    }

    public void setOfferSummaries(List<OfferEstimatedSummary> offerSummaries) {
        this.offerSummaries = offerSummaries;
    }

    public BigDecimal getEstimatedRoomChargesWithOffer() {
        return estimatedRoomChargesWithOffer;
    }

    public void setEstimatedRoomChargesWithOffer(BigDecimal estimatedRoomChargesWithOffer) {
        this.estimatedRoomChargesWithOffer = estimatedRoomChargesWithOffer;
    }
}