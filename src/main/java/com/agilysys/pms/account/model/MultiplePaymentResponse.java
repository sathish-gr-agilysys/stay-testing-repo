/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import com.agilysys.pms.reservation.model.ErrorHandlingMultipleReservation;

public class MultiplePaymentResponse {
    private List<LineItemView> paymentLineItems;
    private List<String> failedAccountIds;
    private List<String> successAccountIds;
    private Map<String, ErrorHandlingMultipleReservation> error;

    public MultiplePaymentResponse() {}

    public MultiplePaymentResponse(List<LineItemView> paymentLineItems, List<String> successAccountIds,
          List<String> failedAccountIds, Map<String, ErrorHandlingMultipleReservation> error) {
        this.paymentLineItems = paymentLineItems;
        this.successAccountIds = successAccountIds;
        this.failedAccountIds = failedAccountIds;
        this.error = error;
    }

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

    public Map<String, ErrorHandlingMultipleReservation> getError() {
        return error;
    }

    public void setError(Map<String, ErrorHandlingMultipleReservation> error) {
        this.error = error;
    }
}
