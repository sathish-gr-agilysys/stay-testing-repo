/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.ComponentRateSnapshot;
import com.agilysys.common.model.rate.OfferSnapshot;

public class OfferDetails {
    private List<OfferSnapshot> offerSnapshots;
    private List<RateDetails> rateSnapshots;

    public List<OfferSnapshot> getOfferSnapshots() {
        return offerSnapshots;
    }

    public void setOfferSnapshots(List<OfferSnapshot> offerSnapshots) {
        this.offerSnapshots = offerSnapshots;
    }

    public List<RateDetails> getRateSnapshots() {
        return rateSnapshots;
    }

    public void setRateSnapshots(List<RateDetails> rateSnapshots) {
        this.rateSnapshots = rateSnapshots;
    }

    public static class RateDetails {
        private LocalDate date;
        private String transactionItemId;
        private String ratePlanId;
        private BigDecimal roomRate;
        private List<ComponentRateSnapshot> componentRateSnapshots;
        private Set<AutoRecurringItemResponse> autoRecurringCharges;

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getTransactionItemId() {
            return transactionItemId;
        }

        public void setTransactionItemId(String transactionItemId) {
            this.transactionItemId = transactionItemId;
        }

        public String getRatePlanId() {
            return ratePlanId;
        }

        public void setRatePlanId(String ratePlanId) {
            this.ratePlanId = ratePlanId;
        }

        public BigDecimal getRoomRate() {
            return roomRate;
        }

        public void setRoomRate(BigDecimal roomRate) {
            this.roomRate = roomRate;
        }

        public List<ComponentRateSnapshot> getComponentRateSnapshots() {
            return componentRateSnapshots;
        }

        public void setComponentRateSnapshots(List<ComponentRateSnapshot> componentRateSnapshots) {
            this.componentRateSnapshots = componentRateSnapshots;
        }

        public Set<AutoRecurringItemResponse> getAutoRecurringCharges() {
            return autoRecurringCharges;
        }

        public void setAutoRecurringCharges(Set<AutoRecurringItemResponse> autoRecurringCharges) {
            this.autoRecurringCharges = autoRecurringCharges;
        }
    }
}
