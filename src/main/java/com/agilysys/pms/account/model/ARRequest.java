/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class ARRequest {

    private String arNumbers;

    public ARRequest() {}

    public ARRequest(String arNumbers) {
        this.arNumbers = arNumbers;
    }

    public String getArNumbers() {
        return arNumbers;
    }

    public void setArNumbers(String arNumbers) {
        this.arNumbers = arNumbers;
    }
}
