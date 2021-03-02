/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.ComponentHelper;
import com.agilysys.common.model.rate.ComponentRateSnapshot;
import com.agilysys.common.model.rate.OfferSnapshot;
import com.agilysys.pms.common.model.RateCalculationBaseType;
import com.agilysys.pms.common.model.ValueType;
import com.agilysys.pms.property.model.AgeCategory;
import com.agilysys.pms.rates.model.Component;
import com.agilysys.pms.rates.model.ComponentBundle;

public class OfferDetails {
    private List<OfferSnapshot> offerSnapshots;
    private List<RateDetails> rateSnapshots;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfAgeCategory1;
    private int numberOfAgeCategory2;
    private int numberOfAgeCategory3;
    private int numberOfAgeCategory4;
    private int numberOfAgeCategory5;
    private int numberOfAgeCategory6;
    private int numberOfAgeCategory7;
    private int numberOfAgeCategory8;
    private List<OfferRecurringCharges> recurringCharges;
    private Map<LocalDate, List<ComponentBundle>> addOns;

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

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfAgeCategory1() {
        return numberOfAgeCategory1;
    }

    public void setNumberOfAgeCategory1(int numberOfAgeCategory1) {
        this.numberOfAgeCategory1 = numberOfAgeCategory1;
    }

    public int getNumberOfAgeCategory2() {
        return numberOfAgeCategory2;
    }

    public void setNumberOfAgeCategory2(int numberOfAgeCategory2) {
        this.numberOfAgeCategory2 = numberOfAgeCategory2;
    }

    public int getNumberOfAgeCategory3() {
        return numberOfAgeCategory3;
    }

    public void setNumberOfAgeCategory3(int numberOfAgeCategory3) {
        this.numberOfAgeCategory3 = numberOfAgeCategory3;
    }

    public int getNumberOfAgeCategory4() {
        return numberOfAgeCategory4;
    }

    public void setNumberOfAgeCategory4(int numberOfAgeCategory4) {
        this.numberOfAgeCategory4 = numberOfAgeCategory4;
    }

    public int getNumberOfAgeCategory5() {
        return numberOfAgeCategory5;
    }

    public void setNumberOfAgeCategory5(int numberOfAgeCategory5) {
        this.numberOfAgeCategory5 = numberOfAgeCategory5;
    }

    public int getNumberOfAgeCategory6() {
        return numberOfAgeCategory6;
    }

    public void setNumberOfAgeCategory6(int numberOfAgeCategory6) {
        this.numberOfAgeCategory6 = numberOfAgeCategory6;
    }

    public int getNumberOfAgeCategory7() {
        return numberOfAgeCategory7;
    }

    public void setNumberOfAgeCategory7(int numberOfAgeCategory7) {
        this.numberOfAgeCategory7 = numberOfAgeCategory7;
    }

    public int getNumberOfAgeCategory8() {
        return numberOfAgeCategory8;
    }

    public void setNumberOfAgeCategory8(int numberOfAgeCategory8) {
        this.numberOfAgeCategory8 = numberOfAgeCategory8;
    }

    public List<OfferRecurringCharges> getRecurringCharges() {
        return recurringCharges;
    }

    public void setRecurringCharges(List<OfferRecurringCharges> recurringCharges) {
        this.recurringCharges = recurringCharges;
    }

    public Map<LocalDate, List<ComponentBundle>> getAddOns() {
        return addOns;
    }

    public void setAddOns(Map<LocalDate, List<ComponentBundle>> addOns) {
        this.addOns = addOns;
    }

    public static Map<LocalDate, List<RecurringChargeView>> getRecurringChargeFromSnapShot(OfferDetails offerDetails,
          List<AgeCategory> ageCategories) {
        Map<LocalDate, List<RecurringChargeView>> recurringChargeViewsByDate = new TreeMap<>();
        Map<LocalDate, List<ComponentBundle>> addOns = offerDetails.getAddOns();
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
                          .getTotalQuantity(componentRateSnapshot.getComponentType(), offerDetails.getNumberOfAdults(),
                                offerDetails.getNumberOfChildren(), offerDetails.getNumberOfAgeCategory1(),
                                offerDetails.getNumberOfAgeCategory2(), offerDetails.getNumberOfAgeCategory3(),
                                offerDetails.getNumberOfAgeCategory4(), offerDetails.getNumberOfAgeCategory5(),
                                offerDetails.getNumberOfAgeCategory6(), offerDetails.getNumberOfAgeCategory7(),
                                offerDetails.getNumberOfAgeCategory8(), componentRateSnapshot.getQuantity(),
                                ageCategories);
                    componentRateSnapshot.setQuantity(quantity);
                    componentRateSnapshot
                          .setTotalAmount(componentRateSnapshot.getAmount().multiply(new BigDecimal(quantity)));
                    componentChargeViews.add(ComponentChargeView.fromComponentRateSnapshot(componentRateSnapshot));
                });
                recurringChargeView.setComponentCharges(componentChargeViews);
            }
            if (MapUtils.isNotEmpty(addOns)) {
                List<ComponentChargeView> addOnComponentChargeViews = recurringChargeView.getComponentCharges();
                if (addOnComponentChargeViews == null) {
                    addOnComponentChargeViews = new ArrayList<>(addOns.size());
                }
                List<ComponentBundle> addOnsForDate = addOns.get(rateDetails.getDate());
                for (ComponentBundle componentBundle : addOnsForDate) {
                    for (Component component : componentBundle.getComponents()) {

                        int quantity = ComponentHelper
                              .getTotalQuantity(component.getComponentType(), offerDetails.getNumberOfAdults(),
                                    offerDetails.getNumberOfChildren(), offerDetails.getNumberOfAgeCategory1(),
                                    offerDetails.getNumberOfAgeCategory2(), offerDetails.getNumberOfAgeCategory3(),
                                    offerDetails.getNumberOfAgeCategory4(), offerDetails.getNumberOfAgeCategory5(),
                                    offerDetails.getNumberOfAgeCategory6(), offerDetails.getNumberOfAgeCategory7(),
                                    offerDetails.getNumberOfAgeCategory8(), component.getQuantity(), ageCategories);

                        ComponentRateSnapshot componentRateSnapshot =
                              new ComponentRateSnapshot(component.getAmount(), componentBundle.getId(),
                                    component.getAmount().multiply(new BigDecimal(quantity)), quantity,
                                    component.getTransactionItemId(), component.getComponentType(),
                                    component.getRoomChargePostingType(), component.getAllowanceComponentType(),
                                    component.getAllowanceAmount(), component.getAllowanceCombinations(),
                                    component.getAllowanceFrequencyType(), component.getAllowanceName(),
                                    component.getQuantity());

                        componentRateSnapshot.setComponentId(component.getId());
                        componentRateSnapshot.setBreakageId(component.getBreakageId());
                        componentRateSnapshot.setAddOn(componentBundle.getCreatedByUser());
                        componentRateSnapshot.setAddOnBundleId(componentBundle.getAddOnBundleId());
                        addOnComponentChargeViews
                              .add(ComponentChargeView.fromComponentRateSnapshot(componentRateSnapshot));
                    }
                }
            }

            recurringChargeViews.add(recurringChargeView);
            if (org.apache.commons.collections.CollectionUtils.isNotEmpty(rateDetails.getAutoRecurringCharges())) {
                for (AutoRecurringItemResponse autoRecurringItem : rateDetails.getAutoRecurringCharges()) {
                    RecurringChargeView autoRecurringChargeView = new RecurringChargeView();
                    autoRecurringChargeView.setChargeDate(rateDetails.getDate());
                    if (autoRecurringItem.getOverriddenCharge() != null) {
                        autoRecurringChargeView.setAmount(autoRecurringItem.getOverriddenCharge());
                    } else {
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
                            autoRecurringChargeView.setAmount(autoRecurringItem.getValue()
                                  .multiply(new BigDecimal(autoRecurringItem.getQuantity())));
                        }
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

        if (CollectionUtils.isNotEmpty(offerDetails.getRecurringCharges())) {
            for (OfferRecurringCharges recurringCharge : offerDetails.getRecurringCharges()) {
                for (OfferRecurringItem recurringItem : recurringCharge.getItems()) {
                    RecurringChargeView recurringChargeView = new RecurringChargeView();
                    recurringChargeView.setRecurringChargeId(recurringItem.getRecurringId());
                    recurringChargeView.setChargeDate(recurringCharge.getChargeDate());
                    recurringChargeView
                          .setAmount(recurringItem.getAmount().multiply(new BigDecimal(recurringItem.getQuantity())));
                    recurringChargeView.setItemId(recurringItem.getItemId());
                    if (Boolean.TRUE.equals(recurringItem.getIsPet())) {
                        recurringChargeView.setPetReferenceId(recurringItem.getId());
                    }
                    List<RecurringChargeView> views = recurringChargeViewsByDate
                          .computeIfAbsent(recurringCharge.getChargeDate(), k -> new ArrayList<>());
                    views.add(recurringChargeView);
                }
            }
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
