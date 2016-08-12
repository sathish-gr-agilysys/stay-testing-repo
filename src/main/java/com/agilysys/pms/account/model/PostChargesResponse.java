package com.agilysys.pms.account.model;

import java.util.List;

public class PostChargesResponse {
    private List<LineItemView> lineItemsList;

    public List<LineItemView> getLineItemsList() {
        return lineItemsList;
    }

    public void setLineItemsList(List<LineItemView> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }
}
