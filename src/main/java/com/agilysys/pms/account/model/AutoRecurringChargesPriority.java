/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

public class AutoRecurringChargesPriority {
    private String tenantId;
    private String propertyId;
    private Map<Integer, AutoRecurringChargeRuleType> priorityOrder;

    public AutoRecurringChargesPriority() {}

    public AutoRecurringChargesPriority(String tenantId, String propertyId, AutoRecurringChargeRuleType firstPriority,
          AutoRecurringChargeRuleType secondPriority, AutoRecurringChargeRuleType thirdPriority,
          AutoRecurringChargeRuleType fourthPriority, AutoRecurringChargeRuleType fifthPriority,
          AutoRecurringChargeRuleType sixthPriority) {
        this.tenantId = tenantId;
        this.propertyId = propertyId;
        this.priorityOrder.put(1, firstPriority);
        this.priorityOrder.put(2, secondPriority);
        this.priorityOrder.put(3, thirdPriority);
        this.priorityOrder.put(4, fourthPriority);
        this.priorityOrder.put(5, fifthPriority);
        this.priorityOrder.put(6, sixthPriority);
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public Map<Integer, AutoRecurringChargeRuleType> getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Map<Integer, AutoRecurringChargeRuleType> priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

}
