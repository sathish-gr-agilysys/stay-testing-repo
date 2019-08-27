/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class PantryTransactionResponse {

    private PostChargesResponse postChargesResponse;
    private List<LineItemView> paymentView;
    private String errorMessage;

    public PostChargesResponse getPostChargesResponse() {
        return postChargesResponse;
    }

    public void setPostChargesResponse(PostChargesResponse postChargesResponse) {
        this.postChargesResponse = postChargesResponse;
    }

    public List<LineItemView> getPaymentView() {
        return paymentView;
    }

    public void setPaymentView(List<LineItemView> paymentView) {
        this.paymentView = paymentView;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}