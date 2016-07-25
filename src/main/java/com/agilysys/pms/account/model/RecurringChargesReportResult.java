package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class RecurringChargesReportResult {
    private Map<String, List<RecurringChargeReportItem>> recurringChargesByReservationId;

    public Map<String, List<RecurringChargeReportItem>> getRecurringChargesByReservationId() {
        return recurringChargesByReservationId;
    }

    public void setRecurringChargesByReservationId(
          Map<String, List<RecurringChargeReportItem>> recurringChargesByReservationId) {
        this.recurringChargesByReservationId = recurringChargesByReservationId;
    }
}
