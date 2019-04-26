/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class RecurringChargesReportResult {
    private Map<String, List<RecurringChargeReportItem>> recurringChargesByReservationId;

    public RecurringChargesReportResult(){

    }

    public RecurringChargesReportResult(Map<String, List<RecurringChargeReportItem>> recurringChargesByReservationId) {
        this.recurringChargesByReservationId = recurringChargesByReservationId;
    }

    public Map<String, List<RecurringChargeReportItem>> getRecurringChargesByReservationId() {
        return recurringChargesByReservationId;
    }

    public void setRecurringChargesByReservationId(
          Map<String, List<RecurringChargeReportItem>> recurringChargesByReservationId) {
        this.recurringChargesByReservationId = recurringChargesByReservationId;
    }
}
