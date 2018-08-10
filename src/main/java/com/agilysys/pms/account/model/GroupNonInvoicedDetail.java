/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class GroupNonInvoicedDetail extends NonInvoicedSourceAccountDetail {
    private List<NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails = new ArrayList<>();

    public List<NonInvoicedSourceAccountDetail> getNonInvoicedSourceAccountDetails() {
        return nonInvoicedSourceAccountDetails;
    }

    public void setNonInvoicedSourceAccountDetails(
          List<NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails) {
        this.nonInvoicedSourceAccountDetails = nonInvoicedSourceAccountDetails;
    }
}
