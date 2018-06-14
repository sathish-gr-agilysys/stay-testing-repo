/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.Map;

public class GroupNonInvoicedDetail extends NonInvoicedSourceAccountDetail{
    private Map<String, NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails;

    public Map<String, NonInvoicedSourceAccountDetail> getNonInvoicedSourceAccountDetails() {
        return nonInvoicedSourceAccountDetails;
    }

    public void setNonInvoicedSourceAccountDetails(
          Map<String, NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails) {
        this.nonInvoicedSourceAccountDetails = nonInvoicedSourceAccountDetails;
    }
}
