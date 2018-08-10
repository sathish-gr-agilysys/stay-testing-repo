/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ARReportRequest {

    private List<String> arNumbers;

    public ARReportRequest() {}

    public ARReportRequest(List<String> arNumbers) {
        this.arNumbers = arNumbers;
    }

    public List<String> getArNumbers() {
        return arNumbers;
    }

    public void setArNumbers(List<String> arNumbers) {
        this.arNumbers = arNumbers;
    }

    public Set<String> getArNumbersSet() {
        Set<String> arNumbersSet = new TreeSet<>();
        arNumbers.forEach(arNumber -> arNumbersSet.add(arNumber.trim()));
        return arNumbersSet;
    }
}
