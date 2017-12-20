/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class RecurringChargeRequest {
    private List<CreateRecurringCharge> createRecurringCharges;
    public List<CreateRecurringCharge> getCreateRecurringCharges() {
        return createRecurringCharges;
    }

    public void setCreateRecurringCharges(List<CreateRecurringCharge> createRecurringCharges) {
        this.createRecurringCharges = createRecurringCharges;
    }
}
