/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EstimatedChargesSummaryView {
    /**
     * The estimate payment due at checkout
     */
    private BigDecimal estimatedPayment = BigDecimal.ZERO;

    /**
     * The estimated charges for the stay (includes room and non-room charges)
     */
    private BigDecimal estimatedCharges = BigDecimal.ZERO;

    /**
     * The estimated room rate = total room charges / length of stay
     */
    private BigDecimal estimatedRoomRate = BigDecimal.ZERO;

    /**
     * The estimated room charges for the stay
     */
    private BigDecimal estimatedRoomCharges = BigDecimal.ZERO;

    /**
     * The taxes for estimated charges
     */
    private BigDecimal estimatedTaxes = BigDecimal.ZERO;

    /**
     * The total of estimated charges and taxes
     */
    private BigDecimal estimatedTotal = BigDecimal.ZERO;

    /**
     * The total of any posted payments
     */
    private BigDecimal postedPayment = BigDecimal.ZERO;

    /**
     * The posted charges
     */
    private BigDecimal postedCharges = BigDecimal.ZERO;

    /**
     * The posted room charges
     */
    private BigDecimal postedRoomCharges = BigDecimal.ZERO;

    /**
     * The posted room taxes
     */
    private BigDecimal postedRoomTaxes = BigDecimal.ZERO;

    /**
     * The taxes for posted charges
     */
    private BigDecimal postedTaxes = BigDecimal.ZERO;

    /**
     * The total of posted charges and taxes
     */
    private BigDecimal postedTotal = BigDecimal.ZERO;

    /**
     * The future charges expected for the stay
     */
    private BigDecimal futureCharges = BigDecimal.ZERO;

    /**
     * The taxes for future charges
     */
    private BigDecimal futureTaxes = BigDecimal.ZERO;

    /**
     * The future room charges expected for the stay
     */
    private BigDecimal futureRoomCharges = BigDecimal.ZERO;

    /**
     * The taxes for future room charges
     */
    private BigDecimal futureRoomTaxes = BigDecimal.ZERO;

    /**
     * The total of future room charges and taxes
     */
    private BigDecimal futureRoomTotal = BigDecimal.ZERO;

    /**
     * The total of future charges and taxes
     */
    private BigDecimal futureTotal = BigDecimal.ZERO;

    /**
     * The room revenue taxes for inclusive components
     */
    private BigDecimal inclusiveComponentsRoomRevenueTaxTotal = BigDecimal.ZERO;

    /**
     * The offer wise offer details
     */
    private List<OfferEstimatedSummary> offerSummaries = new ArrayList<>();

    /**
     * Gets the estimate payment due at checkout
     */
    public BigDecimal getEstimatedPayment() {
        return estimatedPayment;
    }

    /**
     * Sets the estimate payment due at checkout
     */
    public void setEstimatedPayment(BigDecimal estimatedPayment) {
        this.estimatedPayment = estimatedPayment;
    }

    /**
     * Gets the estimated charges for the stay
     */
    public BigDecimal getEstimatedCharges() {
        return estimatedCharges;
    }

    /**
     * Sets the estimated charges for the stay
     */
    public void setEstimatedCharges(BigDecimal estimatedCharges) {
        this.estimatedCharges = estimatedCharges;
    }

    public BigDecimal getEstimatedRoomCharges() {
        return estimatedRoomCharges;
    }

    public void setEstimatedRoomCharges(BigDecimal estimatedRoomCharges) {
        this.estimatedRoomCharges = estimatedRoomCharges;
    }

    public BigDecimal getEstimatedRoomRate() {
        return estimatedRoomRate;
    }

    public void setEstimatedRoomRate(BigDecimal estimatedRoomRate) {
        this.estimatedRoomRate = estimatedRoomRate;
    }

    /**
     * Gets the taxes for estimated charges
     */
    public BigDecimal getEstimatedTaxes() {
        return estimatedTaxes;
    }

    /**
     * Sets the taxes for estimated charges
     */
    public void setEstimatedTaxes(BigDecimal estimatedTaxes) {
        this.estimatedTaxes = estimatedTaxes;
    }

    /**
     * Gets the total of estimated charges and taxes
     */
    public BigDecimal getEstimatedTotal() {
        return estimatedTotal;
    }

    /**
     * Sets the total of estimated charges and taxes
     */
    public void setEstimatedTotal(BigDecimal estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    /**
     * Gets the total of any posted payments
     */
    public BigDecimal getPostedPayment() {
        return postedPayment;
    }

    /**
     * Sets the total of any posted payments
     */
    public void setPostedPayment(BigDecimal postedPayment) {
        this.postedPayment = postedPayment;
    }

    /**
     * Gets the posted charges
     */
    public BigDecimal getPostedCharges() {
        return postedCharges;
    }

    /**
     * Sets the posted charges
     */
    public void setPostedCharges(BigDecimal postedCharges) {
        this.postedCharges = postedCharges;
    }

    public BigDecimal getPostedRoomCharges() {
        return postedRoomCharges;
    }

    public void setPostedRoomCharges(BigDecimal postedRoomCharges) {
        this.postedRoomCharges = postedRoomCharges;
    }

    public BigDecimal getPostedRoomTaxes() {
        return postedRoomTaxes;
    }

    public void setPostedRoomTaxes(BigDecimal postedRoomTaxes) {
        this.postedRoomTaxes = postedRoomTaxes;
    }

    /**
     * Gets the taxes for posted charges
     */
    public BigDecimal getPostedTaxes() {
        return postedTaxes;
    }

    /**
     * Sets the taxes for posted charges
     */
    public void setPostedTaxes(BigDecimal postedTaxes) {
        this.postedTaxes = postedTaxes;
    }

    /**
     * Gets the total of posted charges and taxes
     */
    public BigDecimal getPostedTotal() {
        return postedTotal;
    }

    /**
     * Sets the total of posted charges and taxes
     */
    public void setPostedTotal(BigDecimal postedTotal) {
        this.postedTotal = postedTotal;
    }

    /**
     * Gets the future charges expected for the stay
     */
    public BigDecimal getFutureCharges() {
        return futureCharges;
    }

    /**
     * Sets the future charges expected for the stay
     */
    public void setFutureCharges(BigDecimal futureCharges) {
        this.futureCharges = futureCharges;
    }

    /**
     * Gets the taxes for future charges
     */
    public BigDecimal getFutureTaxes() {
        return futureTaxes;
    }

    /**
     * Gets the taxes for future charges
     */
    public void setFutureTaxes(BigDecimal futureTaxes) {
        this.futureTaxes = futureTaxes;
    }

    /**
     * Gets the total of future charges and taxes
     */
    public BigDecimal getFutureTotal() {
        return futureTotal;
    }

    /**
     * Sets the total of future charges and taxes
     */
    public void setFutureTotal(BigDecimal futureTotal) {
        this.futureTotal = futureTotal;
    }

    public BigDecimal getFutureRoomCharges() {
        return futureRoomCharges;
    }

    public void setFutureRoomCharges(BigDecimal futureRoomCharges) {
        this.futureRoomCharges = futureRoomCharges;
    }

    public BigDecimal getFutureRoomTaxes() {
        return futureRoomTaxes;
    }

    public void setFutureRoomTaxes(BigDecimal futureRoomTaxes) {
        this.futureRoomTaxes = futureRoomTaxes;
    }

    public BigDecimal getFutureRoomTotal() {
        return futureRoomTotal;
    }

    public void setFutureRoomTotal(BigDecimal futureRoomTotal) {
        this.futureRoomTotal = futureRoomTotal;
    }

    public BigDecimal getInclusiveComponentsRoomRevenueTaxTotal() {
        return inclusiveComponentsRoomRevenueTaxTotal;
    }

    public void setInclusiveComponentsRoomRevenueTaxTotal(BigDecimal inclusiveComponentsRoomRevenueTaxTotal) {
        this.inclusiveComponentsRoomRevenueTaxTotal = inclusiveComponentsRoomRevenueTaxTotal;
    }

    public List<OfferEstimatedSummary> getOfferSummaries() {
        return offerSummaries;
    }

    public void setOfferSummaries(List<OfferEstimatedSummary> offerSummaries) {
        this.offerSummaries = offerSummaries;
    }
}
