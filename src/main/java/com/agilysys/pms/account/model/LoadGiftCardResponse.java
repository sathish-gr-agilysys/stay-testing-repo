/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.rguestpayshim.model.giftcard.GiftCardResponse;

public class LoadGiftCardResponse {
    private PostChargesResponse postChargesResponse;
    private GiftCardResponse giftCardResponse;

    public LoadGiftCardResponse() {}

    public LoadGiftCardResponse(PostChargesResponse postChargesResponse, GiftCardResponse giftCardResponse) {
        this.postChargesResponse = postChargesResponse;
        this.giftCardResponse = giftCardResponse;
    }

    public PostChargesResponse getPostChargesResponse() {
        return postChargesResponse;
    }

    public void setPostChargesResponse(PostChargesResponse postChargesResponse) {
        this.postChargesResponse = postChargesResponse;
    }

    public GiftCardResponse getGiftCardResponse() {
        return giftCardResponse;
    }

    public void setGiftCardResponse(GiftCardResponse giftCardResponse) {
        this.giftCardResponse = giftCardResponse;
    }
}
