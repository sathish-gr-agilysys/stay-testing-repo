/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.math.BigDecimal;

public class PostChargesResponse {

    private String parentId;
    private GroupSummary groupSummary;

    private List<LineItemView> lineItemsList;

    public List<LineItemView> getLineItemsList() {
        return lineItemsList;
    }

    public void setLineItemsList(List<LineItemView> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public GroupSummary getGroupSummary() {
        return groupSummary;
    }

    public void setGroupSummary(GroupSummary groupSummary) {
        this.groupSummary = groupSummary;
    }
}
