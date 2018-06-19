/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.payagent;

import com.agilysys.pms.rguestpayshim.exception.PayErrorData;
import com.agilysys.pms.rguestpayshim.model.PayAgentBaseResponse;
import com.agilysys.pms.rguestpayshim.model.token.TokenResponse;
import com.agilysys.pms.rguestpayshim.model.transaction.AuthResponse;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class PayTransactionUpdateRequest {
    private PayAgentBaseResponse payAgentResponse;
    private String typeResponse;

    /**
     * @return the typeResponse
     */
    public String getTypeResponse() {
        return typeResponse;
    }

    /**
     * @param typeResponse the typeResponse to set
     */
    public void setTypeResponse(String typeResponse) {
        this.typeResponse = typeResponse;
    }

    /**
     * @return the response
     */
    public PayAgentBaseResponse getPayAgentResponse() {
        return payAgentResponse;
    }

    /**
     * @param response the response from payAgent to set
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "typeResponse")
    @JsonSubTypes(value = {
          @JsonSubTypes.Type(name = "AuthResponse", value = AuthResponse.class),
          @JsonSubTypes.Type(name = "TokenResponse", value = TokenResponse.class),
          @JsonSubTypes.Type(name = "PayErrorData", value = PayErrorData.class), })
    public void setPayAgentResponse(PayAgentBaseResponse response) {
        this.payAgentResponse = response;
    }
}
