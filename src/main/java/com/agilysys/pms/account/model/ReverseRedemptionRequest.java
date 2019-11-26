/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class ReverseRedemptionRequest {

    private List<String> transactionIds;
    private String playerPin;

    public ReverseRedemptionRequest(){
        transactionIds = new ArrayList<>();
    }

    public ReverseRedemptionRequest(List<String> transactionIds){
        this.transactionIds = transactionIds;
    }

    public List<String> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(List<String> transactionIds) {
        this.transactionIds = transactionIds;
    }

    public String getPlayerPin() {
        return playerPin;
    }

    public void setPlayerPin(String playerPin) {
        this.playerPin = playerPin;
    }
}
