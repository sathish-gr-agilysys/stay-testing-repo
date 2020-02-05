package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.common.model.AutoRecurringChargeRuleType;

public class AutoRecurringChargeRuleResponse {
    private Map<LocalDate, List<AutoRecurringItem>> activeAutoRecurringItemsByDate;
    private String autoRecurringRuleId;
    private AutoRecurringChargeRuleType autoRecurringRulePriority;

    public AutoRecurringChargeRuleResponse() {
        activeAutoRecurringItemsByDate = new HashMap<>();
    }

    public Map<LocalDate, List<AutoRecurringItem>> getActiveAutoRecurringItemsByDate() {
        return activeAutoRecurringItemsByDate;
    }

    public void setActiveAutoRecurringItemsByDate(
          Map<LocalDate, List<AutoRecurringItem>> activeAutoRecurringItemsByDate) {
        this.activeAutoRecurringItemsByDate = activeAutoRecurringItemsByDate;
    }

    public String getAutoRecurringRuleId() {
        return autoRecurringRuleId;
    }

    public void setAutoRecurringRuleId(String autoRecurringRuleId) {
        this.autoRecurringRuleId = autoRecurringRuleId;
    }

    public AutoRecurringChargeRuleType getAutoRecurringRulePriority() {
        return autoRecurringRulePriority;
    }

    public void setAutoRecurringRulePriority(AutoRecurringChargeRuleType autoRecurringRulePriority) {
        this.autoRecurringRulePriority = autoRecurringRulePriority;
    }
}
