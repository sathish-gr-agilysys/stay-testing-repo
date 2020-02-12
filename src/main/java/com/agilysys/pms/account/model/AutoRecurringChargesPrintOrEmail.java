/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class AutoRecurringChargesPrintOrEmail extends AccountingObjectBase {

    private static final String DISPLAY_NAME = "Auto-Recurring-charge rule priority";

    private AutoRecurringChargeRulePrintEmailType printOrEmail;

    public AutoRecurringChargesPrintOrEmail() {}

    public AutoRecurringChargesPrintOrEmail(AutoRecurringChargeRulePrintEmailType printOrEmail) {
        this.printOrEmail = printOrEmail;
    }

    public AutoRecurringChargeRulePrintEmailType getPrintOrEmail() {
        return printOrEmail;
    }

    public void setPrintOrEmail(AutoRecurringChargeRulePrintEmailType printOrEmail) {
        this.printOrEmail = printOrEmail;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

}
