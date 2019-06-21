/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

/**
 * Object needed to return two lists of posting rules
 */
public class PostingRuleDetailView {
    List<PostingRuleDetail> groupRules;
    List<PostingRuleDetail> accountRules;

    /**
     * For GUEST accounts this will contain the rules inherited from the group
     * For GROUP accounts this will contain rules that apply to people within the group, empty set means everyone
     */
    public List<PostingRuleDetail> getGroupRules() {
        return groupRules;
    }

    public void setGroupRules(List<PostingRuleDetail> groupRules) {
        this.groupRules = groupRules;
    }

    /**
     * This contains rules that apply only to the account itself
     */
    public List<PostingRuleDetail> getAccountRules() {
        return accountRules;
    }

    public void setAccountRules(List<PostingRuleDetail> accountRules) {
        this.accountRules = accountRules;
    }
}
