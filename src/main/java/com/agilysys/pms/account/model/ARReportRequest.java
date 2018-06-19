/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.agilysys.common.constants.Constants;

public class ARReportRequest {

    private String arNumbers;

    public ARReportRequest() {}

    public ARReportRequest(String arNumbers) {
        this.arNumbers = arNumbers;
    }

    public String getArNumbers() {
        return arNumbers;
    }

    public void setArNumbers(String arNumbers) {
        this.arNumbers = arNumbers;
    }

    public Set<String> getArNumbersSet(){
        return new TreeSet<>(Arrays.asList(this.arNumbers.split(Constants.SPACE_COMMA_DELIMITER)));
    }
}
