/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class MultipleAccountRecurringCharge {

    private Map<String, String> accountAndFolios;
    private List<CreateRecurringCharge> createRecurringCharges;

    public Map<String, String> getAccountAndFolios() {
        return accountAndFolios;
    }

    public void setAccountAndFolios(Map<String, String> accountAndFolios) {
        this.accountAndFolios = accountAndFolios;
    }

    public List<CreateRecurringCharge> getCreateRecurringCharges() {
        return createRecurringCharges;
    }

    public void setCreateRecurringCharges(List<CreateRecurringCharge> createRecurringCharges) {
        this.createRecurringCharges = createRecurringCharges;
    }
}
