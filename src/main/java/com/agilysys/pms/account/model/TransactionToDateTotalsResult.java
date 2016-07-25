package com.agilysys.pms.account.model;

import java.util.Map;

public class TransactionToDateTotalsResult {
    /**
     * MTD/YTD transaction totals broken down by item ID
     */
    private Map<String, ToDateTotals> totalsByItem;

    public Map<String, ToDateTotals> getTotalsByItem() {
        return totalsByItem;
    }

    public void setTotalsByItem(Map<String, ToDateTotals> totalsByItem) {
        this.totalsByItem = totalsByItem;
    }
}
