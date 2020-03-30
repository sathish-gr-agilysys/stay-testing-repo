/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

public class AutoRecurringChargeRuleParameters {

    private Set<String> accountIds;
    private String modifySharedArc;
    private String overriddenRuleId;

    public AutoRecurringChargeRuleParameters() {}

    public AutoRecurringChargeRuleParameters(Set<String> accountIds, String overriddenRuleId) {
        this.accountIds = accountIds;
        this.overriddenRuleId = overriddenRuleId;
    }

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public String getModifySharedArc() {
        return modifySharedArc;
    }

    public void setModifySharedArc(String modifySharedArc) {
        this.modifySharedArc = modifySharedArc;
    }

    public String getOverriddenRuleId() {
        return overriddenRuleId;
    }

    public void setOverriddenRuleId(String overriddenRuleId) {
        this.overriddenRuleId = overriddenRuleId;
    }
}
