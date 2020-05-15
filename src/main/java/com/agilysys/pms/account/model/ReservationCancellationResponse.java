/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationCancellationResponse {

    private Map<String, List<LineItemView>> lineItemViewByAccountId = new HashMap<>();

    private Map<String, PostCancellationDetail> postCancellationDetailMap = new HashMap<>();

    public Map<String, List<LineItemView>> getLineItemViewByAccountId() {
        return lineItemViewByAccountId;
    }

    public void setLineItemViewByAccountId(Map<String, List<LineItemView>> lineItemViewByAccountId) {
        this.lineItemViewByAccountId = lineItemViewByAccountId;
    }

    public Map<String, PostCancellationDetail> getPostCancellationDetailMap() {
        return postCancellationDetailMap;
    }

    public void setPostCancellationDetailMap(Map<String, PostCancellationDetail> postCancellationDetailMap) {
        this.postCancellationDetailMap = postCancellationDetailMap;
    }
}
