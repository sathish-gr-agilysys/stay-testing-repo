/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

public class TaxExemptReportResult {

    private Map<String, TaxExemptReportItem> taxExemptReportItemMap;

    public Map<String, TaxExemptReportItem> getTaxExemptReportItemMap() {
        return taxExemptReportItemMap;
    }

    public void setTaxExemptReportItemMap(Map<String, TaxExemptReportItem> taxExemptReportItemMap) {
        this.taxExemptReportItemMap = taxExemptReportItemMap;
    }
}
