/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NightAuditReport {
    private String name;
    private BigDecimal startBalance;
    private BigDecimal endBalance;
    private ArrayList<NightAuditReportItem> items;

    //todo: fix or remove this comment
    // In the UI, report items are group and summed by type
    // we are unsure if the UI will be better to have the
    //  grouped here or in the UI. We will be able to decide in
    //  sprint 24 and change it if needed.
    // public Map<String, BigDecimal> getItemBalances()
    // {
    //     // loop through items, put into map by transactionItemId and add to item balance
    // }

    /**
     * @return The name of the report to display
     */
    public String getName() {
        return name;
    }

    /**
     * set the display name
     */
    public void setName(String displayName) {
        this.name = displayName;
    }

    /**
     * @return the starting balance
     */
    public BigDecimal getStartBalance() {
        return startBalance;
    }

    /**
     * set the starting balance
     */
    public void setStartBalance(BigDecimal startBalance) {
        this.startBalance = startBalance;
    }

    /**
     * get the ending balance
     *
     * @return
     */
    public BigDecimal getEndBalance() {
        return endBalance;
    }

    /**
     * set the ending balance
     */
    public void setEndBalance(BigDecimal endBalance) {
        this.endBalance = endBalance;
    }

    /**
     * @return the items associated with this report
     */
    public ArrayList<NightAuditReportItem> getItems() {
        return items;
    }

    /**
     * set the items associated with this report
     */
    public void setItems(ArrayList<NightAuditReportItem> items) {
        this.items = items;
    }
}
