/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiplePaymentResponse {
    private List<LineItemView> paymentLineItems = new ArrayList<>();
    private List<String> failedAccountIds = new ArrayList<>();
    private List<String> successAccountIds = new ArrayList<>();
    private Map<String, String> error = new HashMap<>();

    public List<LineItemView> getPaymentLineItems() {
        return paymentLineItems;
    }

    public void setPaymentLineItems(List<LineItemView> paymentLineItems) {
        this.paymentLineItems = paymentLineItems;
    }

    public List<String> getFailedAccountIds() {
        return failedAccountIds;
    }

    public void setFailedAccountIds(List<String> failedAccountIds) {
        this.failedAccountIds = failedAccountIds;
    }

    public List<String> getSuccessAccountIds() {
        return successAccountIds;
    }

    public void setSuccessAccountIds(List<String> successAccountIds) {
        this.successAccountIds = successAccountIds;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }
}
