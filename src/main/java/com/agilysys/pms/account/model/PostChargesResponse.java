package com.agilysys.pms.account.model;

import java.util.List;
import java.math.BigDecimal;

public class PostChargesResponse {

    private String groupId;
    private BigDecimal totalCharge;
    private BigDecimal chargesCount;

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

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getChargesCount() {
        return chargesCount;
    }

    public void setChargesCount(BigDecimal chargesCount) {
        this.chargesCount = chargesCount;
    }
}
