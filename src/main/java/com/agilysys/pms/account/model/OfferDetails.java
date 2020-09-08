/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.ComponentRateSnapshot;
import com.agilysys.common.model.rate.OfferSnapshot;
import com.agilysys.pms.common.model.RateCalculationBaseType;
import com.agilysys.pms.common.model.ValueType;

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

    public static Map<LocalDate, List<RecurringChargeView>> getRecurringChargeFromSnapShot(OfferDetails offerDetails) {
        Map<LocalDate, List<RecurringChargeView>> recurringChargeViewsByDate = new HashMap<>();
        for (RateDetails rateDetails : offerDetails.getRateSnapshots()) {
            List<RecurringChargeView> recurringChargeViews = new ArrayList<>();
            RecurringChargeView recurringChargeView = new RecurringChargeView();
            recurringChargeView.setRatePlanId(rateDetails.getRatePlanId());
            recurringChargeView.setChargeDate(rateDetails.getDate());
            recurringChargeView.setAmount(rateDetails.getRoomRate());
            recurringChargeView.setItemId(rateDetails.getTransactionItemId());
            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(rateDetails.getComponentRates())) {
                List<ComponentChargeView> componentCharges =
                      ComponentChargeView.fromComponentRateSnapshots(rateDetails.getComponentRates());
                recurringChargeView.setComponentCharges(componentCharges);
            }
            recurringChargeViews.add(recurringChargeView);
            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(rateDetails.getAutoRecurringCharges())) {
                for (AutoRecurringItemResponse autoRecurringItem : rateDetails.getAutoRecurringCharges()) {
                    RecurringChargeView autoRecurringChargeView = new RecurringChargeView();
                    autoRecurringChargeView.setChargeDate(rateDetails.getDate());
                    if (ValueType.PERCENT.equals(autoRecurringItem.getValueType())) {
                        BigDecimal roomRate = rateDetails.getRoomRate();
                        if (autoRecurringItem.getBasedOn()
                              .equals(RateCalculationBaseType.NIGHTLY_ROOM_CHARGE_WITH_COMPONENTS) &&
                              org.apache.commons.collections.CollectionUtils
                                    .isNotEmpty(rateDetails.getComponentRates())) {
                            for (ComponentRateSnapshot componentRateSnapshot : rateDetails.getComponentRates()) {
                                roomRate = roomRate.add(componentRateSnapshot.getTotalAmount());
                            }
                        }
                        BigDecimal baseAmount =
                              roomRate.multiply(autoRecurringItem.getValue().divide(new BigDecimal(100)));
                        autoRecurringChargeView
                              .setAmount(baseAmount.multiply(new BigDecimal(autoRecurringItem.getQuantity())));
                    } else {
                        autoRecurringChargeView.setAmount(
                              autoRecurringItem.getValue().multiply(new BigDecimal(autoRecurringItem.getQuantity())));
                    }
                    autoRecurringChargeView.setQuantity(1);
                    autoRecurringChargeView.setAutoRecurringItemId(autoRecurringItem.getId());
                    autoRecurringChargeView.setAutoRecurringRuleId(autoRecurringItem.getAutoRecurringRuleId());
                    autoRecurringChargeView.setItemId(autoRecurringItem.getParentTransactionItemId());
                    recurringChargeViews.add(autoRecurringChargeView);
                }
            }
            recurringChargeViewsByDate.put(rateDetails.getDate(), recurringChargeViews);
        }
        return recurringChargeViewsByDate;
    }

    public static class RateDetails {
        private LocalDate date;
        private String transactionItemId;
        private String ratePlanId;
        private BigDecimal roomRate;
        private List<ComponentRateSnapshot> componentRates;
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

        public List<ComponentRateSnapshot> getComponentRates() {
            return componentRates;
        }

        public void setComponentRates(List<ComponentRateSnapshot> componentRates) {
            this.componentRates = componentRates;
        }

        public Set<AutoRecurringItemResponse> getAutoRecurringCharges() {
            return autoRecurringCharges;
        }

        public void setAutoRecurringCharges(Set<AutoRecurringItemResponse> autoRecurringCharges) {
            this.autoRecurringCharges = autoRecurringCharges;
        }
    }
}
