/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Set;

public class AutoRecurringChargeRuleParameters {

    private Set<String> accountIds;
    private String overriddenRuleId;
    private Set<String> shareIds;
    private boolean reCalculateShare;
    private boolean markAsOverridden;

    public AutoRecurringChargeRuleParameters() {}

    public AutoRecurringChargeRuleParameters(Set<String> accountIds, String overriddenRuleId, Set<String> shareIds,
          boolean reCalculateShare, boolean markAsOverridden) {
        this.accountIds = accountIds;
        this.overriddenRuleId = overriddenRuleId;
        this.reCalculateShare = reCalculateShare;
        this.shareIds = shareIds;
        this.markAsOverridden = markAsOverridden;
    }

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public String getOverriddenRuleId() {
        return overriddenRuleId;
    }

    public void setOverriddenRuleId(String overriddenRuleId) {
        this.overriddenRuleId = overriddenRuleId;
    }

    public boolean isReCalculateShare() {
        return reCalculateShare;
    }

    public void setReCalculateShare(boolean reCalculateShare) {
        this.reCalculateShare = reCalculateShare;
    }

    public Set<String> getShareIds() {
        return shareIds;
    }

    public void setShareIds(Set<String> shareIds) {
        this.shareIds = shareIds;
    }

    public boolean isMarkAsOverridden() {
        return markAsOverridden;
    }

    public void setMarkAsOverridden(boolean markAsOverridden) {
        this.markAsOverridden = markAsOverridden;
    }
}
