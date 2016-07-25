/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 **/
package com.agilysys.pms.account.model.payagent;

public enum PayAgentResponseType {

    AUTH_RESPONSE("AuthResponse"),
    TOKEN_RESPONSE("TokenResponse"),
    SALE_RESPONSE("SaleResponse"),
    ERROR_RESPONSE("PayErrorData");
    private String name;

    PayAgentResponseType(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
