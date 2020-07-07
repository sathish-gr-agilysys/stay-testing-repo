/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class ReverseRedemptionRequest {

    private List<String> transactionIds;
    private String playerOrCardId;

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

    public String getPlayerOrCardId() {
        return playerOrCardId;
    }

    public void setPlayerOrCardId(String playerOrCardId) {
        this.playerOrCardId = playerOrCardId;
    }
}
