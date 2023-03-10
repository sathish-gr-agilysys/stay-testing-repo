/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.agilysys.common.model.AutoRecurringChargeRuleType;

public class AutoRecurringChargesPriority extends AccountingObjectBase {

    private static final String DISPLAY_NAME = "Auto-Recurring-charge rule priority";

    private Map<Integer, AutoRecurringChargeRuleType> priorityOrder;

    public AutoRecurringChargesPriority() {}

    public AutoRecurringChargesPriority(Map<Integer, AutoRecurringChargeRuleType> priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public AutoRecurringChargesPriority(AutoRecurringChargeRuleType firstPriority,
          AutoRecurringChargeRuleType secondPriority, AutoRecurringChargeRuleType thirdPriority,
          AutoRecurringChargeRuleType fourthPriority, AutoRecurringChargeRuleType fifthPriority,
          AutoRecurringChargeRuleType sixthPriority, AutoRecurringChargeRuleType seventhPriority) {
        this.priorityOrder.put(1, firstPriority);
        this.priorityOrder.put(2, secondPriority);
        this.priorityOrder.put(3, thirdPriority);
        this.priorityOrder.put(4, fourthPriority);
        this.priorityOrder.put(5, fifthPriority);
        this.priorityOrder.put(6, sixthPriority);
        this.priorityOrder.put(7, seventhPriority);
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

    public Map<AutoRecurringChargeRuleType, Integer> getPriorityByRuleType() {
        Map<AutoRecurringChargeRuleType, Integer> priorityByRule = new HashMap<>();
        if (priorityOrder == null) {
            return Collections.EMPTY_MAP;
        }
        for (Entry<Integer, AutoRecurringChargeRuleType> entry : priorityOrder.entrySet()) {
            priorityByRule.put(entry.getValue(), entry.getKey());
        }
        return priorityByRule;
    }
}
