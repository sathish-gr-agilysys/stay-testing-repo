/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateInvoiceLineItemsRequest {
    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    private List<String> lineItemIds;

    public List<String> getLineItemIds() {
        return lineItemIds;
    }

    public void setLineItemIds(List<String> lineItemIds) {
        this.lineItemIds = lineItemIds;
    }
}
