/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AutoRecurringItemResponse extends AutoRecurringItem {
    private int quantity;
    private String autoRecurringRuleId;

    public AutoRecurringItemResponse() {
    }

    public AutoRecurringItemResponse(AutoRecurringItem autoRecurringItem) {
        this();
        this.id = autoRecurringItem.getId();
        this.value = autoRecurringItem.getValue();
        this.valueType = autoRecurringItem.getValueType();
        this.basedOn = autoRecurringItem.getBasedOn();
        this.defaultSourceId = autoRecurringItem.getDefaultSourceId();
        this.frequencyType = autoRecurringItem.getFrequencyType();
        this.occurrenceDays = autoRecurringItem.getOccurrenceDays();
        this.parentTransactionItemId = autoRecurringItem.getParentTransactionItemId();
        this.status = autoRecurringItem.getStatus();
        this.nNights = autoRecurringItem.getnNights();
        this.startDate = autoRecurringItem.getStartDate();
        this.endDate = autoRecurringItem.getEndDate();
        this.description = autoRecurringItem.getDescription();
        this.applicableFor = autoRecurringItem.getApplicableFor();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAutoRecurringRuleId() {
        return autoRecurringRuleId;
    }

    public void setAutoRecurringRuleId(String autoRecurringRuleId) {
        this.autoRecurringRuleId = autoRecurringRuleId;
    }
}
