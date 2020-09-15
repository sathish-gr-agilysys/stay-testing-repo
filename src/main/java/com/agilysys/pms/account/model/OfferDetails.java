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

import com.agilysys.common.model.rate.ComponentHelper;
import com.agilysys.common.model.rate.ComponentRateSnapshot;
import com.agilysys.common.model.rate.OfferSnapshot;
import com.agilysys.pms.common.model.RateCalculationBaseType;
import com.agilysys.pms.common.model.ValueType;
import com.agilysys.pms.property.model.AgeCategory;

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

    public static Map<LocalDate, List<RecurringChargeView>> getRecurringChargeFromSnapShot(OfferDetails offerDetails,
          List<AgeCategory> ageCategories) {
        Map<LocalDate, List<RecurringChargeView>> recurringChargeViewsByDate = new HashMap<>();
        for (RateDetails rateDetails : offerDetails.getRateSnapshots()) {
            List<RecurringChargeView> recurringChargeViews = new ArrayList<>();
            RecurringChargeView recurringChargeView = new RecurringChargeView();
            recurringChargeView.setRatePlanId(rateDetails.getRatePlanId());
            recurringChargeView.setChargeDate(rateDetails.getDate());
            recurringChargeView.setAmount(rateDetails.getRoomRate());
            recurringChargeView.setItemId(rateDetails.getTransactionItemId());
            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(rateDetails.getComponentRates())) {
                List<ComponentChargeView> componentChargeViews =
                      new ArrayList<>(rateDetails.getComponentRates().size());
                rateDetails.getComponentRates().stream().forEach(componentRateSnapshot -> {
                    int quantity = ComponentHelper
                          .getTotalQuantity(componentRateSnapshot.getComponentType(), rateDetails.getAdultsIncluded(),
                                rateDetails.getChildrenIncluded(), rateDetails.getAgeCategory1Included(),
                                rateDetails.getAgeCategory2Included(), rateDetails.getAgeCategory3Included(),
                                rateDetails.getAgeCategory4Included(), rateDetails.getAgeCategory5Included(),
                                rateDetails.getAgeCategory6Included(), rateDetails.getAgeCategory7Included(),
                                rateDetails.getAgeCategory8Included(), componentRateSnapshot.getQuantity(),
                                ageCategories);
                    componentRateSnapshot.setQuantity(quantity);
                    componentRateSnapshot
                          .setTotalAmount(componentRateSnapshot.getAmount().multiply(new BigDecimal(quantity)));
                    componentChargeViews.add(ComponentChargeView.fromComponentRateSnapshot(componentRateSnapshot));
                });
                recurringChargeView.setComponentCharges(componentChargeViews);
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
        private int adultsIncluded;
        private int childrenIncluded;
        private int ageCategory1Included;
        private int ageCategory2Included;
        private int ageCategory3Included;
        private int ageCategory4Included;
        private int ageCategory5Included;
        private int ageCategory6Included;
        private int ageCategory7Included;
        private int ageCategory8Included;

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

        public int getAdultsIncluded() {
            return adultsIncluded;
        }

        public void setAdultsIncluded(int adultsIncluded) {
            this.adultsIncluded = adultsIncluded;
        }

        public int getChildrenIncluded() {
            return childrenIncluded;
        }

        public void setChildrenIncluded(int childrenIncluded) {
            this.childrenIncluded = childrenIncluded;
        }

        public int getAgeCategory1Included() {
            return ageCategory1Included;
        }

        public void setAgeCategory1Included(int ageCategory1Included) {
            this.ageCategory1Included = ageCategory1Included;
        }

        public int getAgeCategory2Included() {
            return ageCategory2Included;
        }

        public void setAgeCategory2Included(int ageCategory2Included) {
            this.ageCategory2Included = ageCategory2Included;
        }

        public int getAgeCategory3Included() {
            return ageCategory3Included;
        }

        public void setAgeCategory3Included(int ageCategory3Included) {
            this.ageCategory3Included = ageCategory3Included;
        }

        public int getAgeCategory4Included() {
            return ageCategory4Included;
        }

        public void setAgeCategory4Included(int ageCategory4Included) {
            this.ageCategory4Included = ageCategory4Included;
        }

        public int getAgeCategory5Included() {
            return ageCategory5Included;
        }

        public void setAgeCategory5Included(int ageCategory5Included) {
            this.ageCategory5Included = ageCategory5Included;
        }

        public int getAgeCategory6Included() {
            return ageCategory6Included;
        }

        public void setAgeCategory6Included(int ageCategory6Included) {
            this.ageCategory6Included = ageCategory6Included;
        }

        public int getAgeCategory7Included() {
            return ageCategory7Included;
        }

        public void setAgeCategory7Included(int ageCategory7Included) {
            this.ageCategory7Included = ageCategory7Included;
        }

        public int getAgeCategory8Included() {
            return ageCategory8Included;
        }

        public void setAgeCategory8Included(int ageCategory8Included) {
            this.ageCategory8Included = ageCategory8Included;
        }
    }
}
