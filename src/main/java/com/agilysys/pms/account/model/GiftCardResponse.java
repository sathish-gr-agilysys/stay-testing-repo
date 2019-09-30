/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.rguestpayshim.model.giftcard.TransactionResponse;

public class GiftCardResponse {
    private PostChargesResponse postChargesResponse;
    private TransactionResponse transactionResponse;

    public GiftCardResponse() {}

    public GiftCardResponse(PostChargesResponse postChargesResponse, TransactionResponse transactionResponse) {
        this.postChargesResponse = postChargesResponse;
        this.transactionResponse = transactionResponse;
    }

    public PostChargesResponse getPostChargesResponse() {
        return postChargesResponse;
    }

    public void setPostChargesResponse(PostChargesResponse postChargesResponse) {
        this.postChargesResponse = postChargesResponse;
    }

    public TransactionResponse getTransactionResponse() {
        return transactionResponse;
    }

    public void setTransactionResponse(TransactionResponse transactionResponse) {
        this.transactionResponse = transactionResponse;
    }
}
