/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateInvoiceLineItemsRequest {
    @JsonProperty(required = true)
    @Size(min = 1)
    private List<String> lineItemIds;

    private String disputeComment;

    public List<String> getLineItemIds() {
        return lineItemIds;
    }

    public void setLineItemIds(List<String> lineItemIds) {
        this.lineItemIds = lineItemIds;
    }

    public String getDisputeComment() {
        return disputeComment;
    }

    public void setDisputeComment(String disputeComment) {
        this.disputeComment = disputeComment;
    }
}
