/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

public class AutoRecurringChargesPriority extends AccountingObjectBase {

    private static final String DISPLAY_NAME = "Auto-Recurring-charge rule priority";

    private Map<Integer, AutoRecurringChargeRuleType> priorityOrder;

    public AutoRecurringChargesPriority() {}

    public AutoRecurringChargesPriority(Map<Integer, AutoRecurringChargeRuleType> priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public Map<Integer, AutoRecurringChargeRuleType> getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Map<Integer, AutoRecurringChargeRuleType> priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
