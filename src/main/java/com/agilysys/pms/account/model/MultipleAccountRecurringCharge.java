/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Set;

public class MultipleAccountRecurringCharge {
    private Set<String> accountIds;
    private List<CreateRecurringCharge> createRecurringCharges;

    public MultipleAccountRecurringCharge() {}

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public List<CreateRecurringCharge> getCreateRecurringCharges() {
        return createRecurringCharges;
    }

    public void setCreateRecurringCharges(List<CreateRecurringCharge> createRecurringCharges) {
        this.createRecurringCharges = createRecurringCharges;
    }
}
