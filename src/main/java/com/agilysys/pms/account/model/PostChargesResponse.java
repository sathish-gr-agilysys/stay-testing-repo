package com.agilysys.pms.account.model;

import java.util.List;
import java.math.BigDecimal;

public class PostChargesResponse {

    private String groupId;
    private GroupSummary groupSummary;

    private List<LineItemView> lineItemsList;

    public List<LineItemView> getLineItemsList() {
        return lineItemsList;
    }

    public void setLineItemsList(List<LineItemView> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public GroupSummary getGroupSummary() {
        return groupSummary;
    }

    public void setGroupSummary(GroupSummary groupSummary) {
        this.groupSummary = groupSummary;
    }
}
